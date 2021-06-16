package br.com.zup.orange.service;

import br.com.zup.orange.domain.Veiculo;
import br.com.zup.orange.exception.ModeloNotFoundException;
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

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> listAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo save(VeiculoPostRequestBody veiculoPostRequestBody) throws MarcaNotFoundException, ModeloNotFoundException {
        String precoVeiculo = new BuscaValorFipeService().buscaPrecoVeiculo(veiculoPostRequestBody);
        return veiculoRepository.save(veiculoPostRequestBody.build(precoVeiculo));
    }

    public Veiculo save(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }


    public Optional<Veiculo> findById(Long veiculoId) {
//        Veiculo veiculo = veiculoService.findById(veiculoId).get();
        return veiculoRepository.findById(veiculoId);
    }
}
