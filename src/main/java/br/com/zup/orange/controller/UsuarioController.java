package br.com.zup.orange.controller;

import br.com.zup.orange.domain.Usuario;
import br.com.zup.orange.dto.UsuarioPostRequestBody;
import br.com.zup.orange.exception.UsuarioNotFoundException;
import br.com.zup.orange.service.UsuarioService;
import br.com.zup.orange.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;
    private VeiculoService veiculoService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, VeiculoService veiculoService) {
        this.usuarioService = usuarioService;
        this.veiculoService = veiculoService;
    }

    @PostMapping
    ResponseEntity<String> save(@Valid @RequestBody UsuarioPostRequestBody usuarioPostRequestBody) {
        usuarioService.save(usuarioPostRequestBody);
        return new ResponseEntity<>("Usuário cadastrado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/{usuarioId}")
    public Usuario atribuiVeiculoParaUsuario (@PathVariable Long usuarioId) throws UsuarioNotFoundException {
        Optional<Usuario> usuarioOptional =  usuarioService.findById(usuarioId);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new UsuarioNotFoundException());
        return usuario;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {UsuarioNotFoundException.class})
    public String handleUsuarioNotFoundExceptions(Exception ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}