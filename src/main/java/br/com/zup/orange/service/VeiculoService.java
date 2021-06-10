package br.com.zup.orange.service;

import br.com.zup.orange.domain.Veiculo;
import br.com.zup.orange.repository.VeiculoRepository;
import br.com.zup.orange.requests.VeiculoPostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Veiculo save(VeiculoPostRequestBody veiculoPostRequestBody) {
        return veiculoRepository.save(veiculoPostRequestBody.build());
    }
}
