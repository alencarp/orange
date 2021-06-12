package br.com.zup.orange.service;


import br.com.zup.orange.domain.Marca;
import br.com.zup.orange.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MarcaService {
    @Autowired
    private RestTemplate restTemplate;

    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca[] getMarca() {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("parallelum.com.br")
                .path("fipe/api/v1/carros/marcas")
//				.path("59")
//				.path("/modelos/")
//				.path("5940")
//				.path("/anos")
                .build();


        ResponseEntity<Marca[]> responseEntityMarca = restTemplate.getForEntity(uri.toUriString(), Marca[].class);
        Marca[] marcasArray = responseEntityMarca.getBody();
        populaMarca(marcasArray);
        return marcasArray;
    }

    public void populaMarca(Marca[] marcasArray) {
        for (Marca m : marcasArray) {
            Marca marca = new Marca();
            marca.setNome(m.getNome());
            marca.setCodigo(m.getCodigo());
            marcaRepository.save(marca);
            System.out.println(marca.getNome());
            System.out.println(marca.getCodigo());
        }
    }
}
