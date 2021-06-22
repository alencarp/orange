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

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    private VeiculoRepository veiculoRepository;
    private UsuarioRepository usuarioRepository;
    private BuscaValorFipeService buscaValorFipeService;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository, UsuarioRepository usuarioRepository, BuscaValorFipeService buscaValorFipeService) {
        this.veiculoRepository = veiculoRepository;
        this.usuarioRepository = usuarioRepository;
        this.buscaValorFipeService = buscaValorFipeService;
    }

    public List<Veiculo> listAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo save(VeiculoPostRequestBody veiculoPostRequestBody) throws MarcaNotFoundException,
            ModeloNotFoundException, UsuarioNotFoundException {
        String precoVeiculo = buscaValorFipeService.buscaPrecoVeiculo(veiculoPostRequestBody);
        Optional<Usuario> usuario = usuarioRepository.findById(veiculoPostRequestBody.getUsuarioId());
        String rodizioDiaDaSemana = buscarDiaRodizio(veiculoPostRequestBody);
        boolean isrodizioAtivo = rodizioAtivo(rodizioDiaDaSemana);
        if (usuario.isEmpty()){
            throw new UsuarioNotFoundException();
        }
        return veiculoRepository.save(build(precoVeiculo, usuario.get(), rodizioDiaDaSemana, isrodizioAtivo,
                veiculoPostRequestBody));
    }

    public Veiculo build(String valor, Usuario usuario, String rodizioDiaDaSemana, boolean isRodizioAtivo,
                         VeiculoPostRequestBody veiculoPostRequestBody) {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(veiculoPostRequestBody.getMarca());
        veiculo.setModelo(veiculoPostRequestBody.getModelo());
        veiculo.setAno(veiculoPostRequestBody.getAno());
        veiculo.setValor(valor);
        veiculo.setUsuario(usuario);
        veiculo.setDiaRodizio(rodizioDiaDaSemana);
        veiculo.setRodizioAtivo(isRodizioAtivo);
        return veiculo;
    }

    private String buscarDiaRodizio(VeiculoPostRequestBody veiculoPostRequestBody) {
        String diaDaSemana;
        int diaRodizio = (Math.abs(veiculoPostRequestBody.getAno()) % 10);
        switch (diaRodizio) {
            case 0: case 1: diaDaSemana = "segunda-feira";
                break;
            case 2: case 3: diaDaSemana = "terça-feira";
                break;
            case 4: case 5: diaDaSemana = "quarta-feira";
                break;
            case 6: case 7: diaDaSemana = "quinta-feira";
                break;
            case 8: case 9: diaDaSemana = "sexta-feira";
                break;
            default: diaDaSemana = "Número inválido para dia de rodízio.";
        }
        return diaDaSemana;
    }

    private boolean rodizioAtivo(String rodizioDiaDaSemana) {
        String diaDeHojedaSemana = null;
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        String[] days = {"domingo", "segunda-feira", "terça-feira", "quarta-feira", "quinta-feira",
                "sexta-feira", "sábado"};
        for (int i = 0; i < 7; i++) {
            if (dayOfWeek == i+1) {
                diaDeHojedaSemana = days[i];
            }
        }
        if (diaDeHojedaSemana.equalsIgnoreCase(rodizioDiaDaSemana)) {
            return true;
        }
        return false;
    }

    public Optional<Veiculo> findById(Long veiculoId) {
        return veiculoRepository.findById(veiculoId);
    }
}
