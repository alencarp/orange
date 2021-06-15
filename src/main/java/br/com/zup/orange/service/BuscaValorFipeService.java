package br.com.zup.orange.service;


import br.com.zup.orange.dto.MarcaResponseBody;
import br.com.zup.orange.dto.ModeloResponseBody;
import br.com.zup.orange.dto.ModelosListaResponseBody;
import br.com.zup.orange.dto.VeiculoPostRequestBody;
import br.com.zup.orange.service.exception.MarcaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class BuscaValorFipeService {
    @Autowired
    private RestTemplate restTemplate;

    private String marca;
    private String modelo;
    private int ano;
    private int codigoMarca;
    private int codigoModelo;
    private int codigoAno;

    public double buscaPrecoVeiculo(VeiculoPostRequestBody veiculoPostRequestBody) throws MarcaNotFoundException {
        marca = veiculoPostRequestBody.getMarca();
        modelo = veiculoPostRequestBody.getModelo();
        ano = veiculoPostRequestBody.getAno();

        codigoMarca = buscaCodigoMarcaByNome(buscaMarca());
        codigoModelo = buscaCodigoModeloByNome(buscaModelo());
        codigoAno = buscaCodigoAnoByNome();
        return buscaValor();


    }

    private double buscaValor() {
        return 0.0;
    }

    private int buscaCodigoAnoByNome() {
        return 0;
    }





    private MarcaResponseBody[] buscaMarca() {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("parallelum.com.br")
                .path("fipe/api/v1/carros/marcas")
//				.path("59")
//				.path("/modelos/")
//				.path("5940")
//				.path("/anos")
                .build();

        ResponseEntity<MarcaResponseBody[]> responseEntityMarca = restTemplate.getForEntity(uri.toUriString(), MarcaResponseBody[].class);
        MarcaResponseBody[] marcasArray = responseEntityMarca.getBody();
        imprimirMarca(marcasArray);
        return marcasArray;
    }


    private int buscaCodigoMarcaByNome(MarcaResponseBody[] marcasArray) throws MarcaNotFoundException {

        for (MarcaResponseBody m : marcasArray) {
            if (m.getNome().equalsIgnoreCase(marca)) {
                return m.getCodigo();
            }
        }
        throw new MarcaNotFoundException();
    }

    public ModelosListaResponseBody buscaModelo() throws MarcaNotFoundException {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("parallelum.com.br")
                .path("fipe/api/v1/carros/marcas")
				.path(String.valueOf(codigoMarca))
				.path("/modelos")
//				.path("5940")
//				.path("/anos")
                .build();


        ResponseEntity<ModelosListaResponseBody> responseEntityModelos = restTemplate.getForEntity(uri.toUriString(), ModelosListaResponseBody.class);
        ModelosListaResponseBody modelosListaResponseBody = responseEntityModelos.getBody();
        imprimirModelo(modelosListaResponseBody);
        return modelosListaResponseBody;
    }

    private int buscaCodigoModeloByNome(ModelosListaResponseBody modelosListaResponseBody) {
        for (ModeloResponseBody modeloResponseBody : modelosListaResponseBody.getModelos()) {


        }
        return 0;
    }

    public void imprimirModelo(ModelosListaResponseBody modelosListaResponseBody) {
        for (ModeloResponseBody modeloResponseBody : modelosListaResponseBody.getModelos()) {
            System.out.println(modeloResponseBody.getNome());
            System.out.println(modeloResponseBody.getCodigo());
        }
    }


    public void imprimirMarca(MarcaResponseBody[] marcasArray) {
        for (MarcaResponseBody m : marcasArray) {
//            MarcaResponseBody marca = new MarcaResponseBody();
//            marca.setNome(m.getNome());
//            marca.setCodigo(m.getCodigo());
            //marcaRepository.save(marca);
            System.out.println(m.getNome());
            System.out.println(m.getCodigo());
        }
    }


}
