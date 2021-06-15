package br.com.zup.orange.service;

import br.com.zup.orange.domain.Veiculo;
import br.com.zup.orange.repository.VeiculoRepository;
import br.com.zup.orange.dto.VeiculoPostRequestBody;
import br.com.zup.orange.service.exception.MarcaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {
    private VeiculoRepository veiculoRepository;
    private BuscaValorFipeService buscaValorFipeService;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> listAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo save(VeiculoPostRequestBody veiculoPostRequestBody) throws MarcaNotFoundException {
        double precoVeiculo = new BuscaValorFipeService().buscaPrecoVeiculo(veiculoPostRequestBody);
        return veiculoRepository.save(veiculoPostRequestBody.build(precoVeiculo));
    }
}
