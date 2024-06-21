package br.com.zup.orange.controller;

import br.com.zup.orange.domain.Usuario;
import br.com.zup.orange.domain.Veiculo;
import br.com.zup.orange.dto.VeiculoPostRequestBody;
import br.com.zup.orange.exception.ModeloNotFoundException;
import br.com.zup.orange.exception.UsuarioNotFoundException;
import br.com.zup.orange.service.UsuarioService;
import br.com.zup.orange.service.VeiculoService;
import br.com.zup.orange.exception.MarcaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {
    private VeiculoService veiculoService;

    private UsuarioService usuarioService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService, UsuarioService usuarioService) {

        this.veiculoService = veiculoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody VeiculoPostRequestBody veiculoPostRequestBody) throws
            MarcaNotFoundException, ModeloNotFoundException, UsuarioNotFoundException {
                veiculoService.createAndSave(veiculoPostRequestBody);
                return new ResponseEntity<>("Veículo cadastrado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{veiculoId}/usuario/{usuarioId}")
    public Veiculo atribuiUsuarioToVeiculo(
            @PathVariable Long usuarioId,
            @PathVariable Long veiculoId
    ) {
        Veiculo veiculo = veiculoService.findById(veiculoId).get();
        Usuario usuario = usuarioService.findById(usuarioId).get();
        veiculo.atribuiUsuario(usuario);
        return veiculoService.save(veiculo);
    }



    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {UsuarioNotFoundException.class, ModeloNotFoundException.class,
            MarcaNotFoundException.class})
    public String handleNotFoundExceptions(Exception ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }
        return errors;
    }
}