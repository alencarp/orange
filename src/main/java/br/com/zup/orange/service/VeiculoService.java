package br.com.zup.orange.service;

import br.com.zup.orange.domain.Usuario;
import br.com.zup.orange.domain.Veiculo;
import br.com.zup.orange.exception.ModeloNotFoundException;
import br.com.zup.orange.exception.UsuarioNotFoundException;
import br.com.zup.orange.repository.UsuarioRepository;
import br.com.zup.orange.repository.VeiculoRepository;
import br.com.zup.orange.dto.VeiculoPostRequestBody;
import br.com.zup.orange.exception.MarcaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    private VeiculoRepository veiculoRepository;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository, UsuarioRepository usuarioRepository) {
        this.veiculoRepository = veiculoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Veiculo> listAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo save(VeiculoPostRequestBody veiculoPostRequestBody) throws MarcaNotFoundException, ModeloNotFoundException, UsuarioNotFoundException {
        String precoVeiculo = new BuscaValorFipeService().buscaPrecoVeiculo(veiculoPostRequestBody);
        Optional<Usuario> usuario = usuarioRepository.findById(veiculoPostRequestBody.getUsuarioId());
        if (usuario.isEmpty()){
            throw new UsuarioNotFoundException();
        }
        return veiculoRepository.save(build(precoVeiculo, usuario.get(), veiculoPostRequestBody));
    }

    public Veiculo build(String valor, Usuario usuario, VeiculoPostRequestBody veiculoPostRequestBody) {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(veiculoPostRequestBody.getMarca());
        veiculo.setModelo(veiculoPostRequestBody.getModelo());
        veiculo.setAno(veiculoPostRequestBody.getAno());
        veiculo.setValor(valor);
        veiculo.setUsuario(usuario);
        return veiculo;
    }

    public Optional<Veiculo> findById(Long veiculoId) {
//        Veiculo veiculo = veiculoService.findById(veiculoId).get();
        return veiculoRepository.findById(veiculoId);
    }
}
