package br.com.zup.orange.service;

import br.com.zup.orange.dto.*;
import br.com.zup.orange.exception.MarcaNotFoundException;
import br.com.zup.orange.exception.ModeloNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class BuscaValorFipeService {

    private RestTemplate restTemplate = new RestTemplate();

    public String buscaPrecoVeiculo(VeiculoPostRequestBody veiculoPostRequestBody) throws MarcaNotFoundException, ModeloNotFoundException {
        MarcaResponseBody[] marcasArray = buscarMarca();
        String marca = veiculoPostRequestBody.getMarca();
        int codigoMarca = buscaCodigoMarcaByNome(marcasArray, marca);
        System.out.println("Codigo da Marca: " + codigoMarca);

        ModelosListaResponseBody modelosListaResponseBody = buscarModelo(codigoMarca);
        String modelo = veiculoPostRequestBody.getModelo();
        int codigoModelo = buscaCodigoModeloByNome(modelosListaResponseBody, modelo);
        System.out.println("Código do Modelo: " + codigoModelo);

        AnoResponseBody[] anosArray = buscarAno(codigoMarca, codigoModelo);
        int anoPostman = veiculoPostRequestBody.getAno();
        String codigoAno = buscaCodigoAnoByNome(anosArray, anoPostman);
        System.out.println("Código do ano: " + codigoAno);

        ValorResponseBody valorResponseBody = buscarValor(codigoMarca, codigoModelo, codigoAno);
        String valorCarro = valorResponseBody.getValor();
        System.out.println("Valor do Carro: " + valorCarro);
        return valorCarro;

    }


    private MarcaResponseBody[] buscarMarca() {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("parallelum.com.br")
                .path("fipe/api/v1/carros/marcas")
                .build();
        System.out.println("URI Marca: " + uri.toUriString());
        ResponseEntity<MarcaResponseBody[]> responseEntityMarca = restTemplate.getForEntity(uri.toUriString(), MarcaResponseBody[].class);
        MarcaResponseBody[] marcasArray = responseEntityMarca.getBody();
//        imprimirMarca(marcasArray);
        return marcasArray;
    }


    private int buscaCodigoMarcaByNome(MarcaResponseBody[] marcasArray, String marca) throws MarcaNotFoundException {
        for (MarcaResponseBody m : marcasArray) {
            if (m.getNome().equalsIgnoreCase(marca)) {
                return m.getCodigo();
            }
        }
        throw new MarcaNotFoundException();
    }

    public void imprimirMarca(MarcaResponseBody[] marcasArray) {
        for (MarcaResponseBody m : marcasArray) {
            MarcaResponseBody marca = new MarcaResponseBody();
            System.out.println(m.getNome());
            System.out.println(m.getCodigo());
        }
    }

    public ModelosListaResponseBody buscarModelo(int codigoMarca) throws ModeloNotFoundException {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("parallelum.com.br")
                .path("fipe/api/v1/carros/marcas/")
				.path(String.valueOf(codigoMarca))
				.path("/modelos")
                .build();
        System.out.println("URI Modelos: " + uri.toUriString());
        ResponseEntity<ModelosListaResponseBody> responseEntityModelos = restTemplate.getForEntity(uri.toUriString(), ModelosListaResponseBody.class);
        ModelosListaResponseBody modelosListaResponseBody = responseEntityModelos.getBody();
//        imprimirModelo(modelosListaResponseBody);
        return modelosListaResponseBody;
    }

    private int buscaCodigoModeloByNome(ModelosListaResponseBody modelosListaResponseBody, String modelo) throws ModeloNotFoundException {
        for (ModeloResponseBody modeloResponseBody : modelosListaResponseBody.getModelos()) {
            if (modeloResponseBody.getNome().equalsIgnoreCase(modelo)) {
                return modeloResponseBody.getCodigo();
            }
        }
        throw new ModeloNotFoundException();
    }

    public void imprimirModelo(ModelosListaResponseBody modelosListaResponseBody) {
        for (ModeloResponseBody modeloResponseBody : modelosListaResponseBody.getModelos()) {
            System.out.println(modeloResponseBody.getNome());
            System.out.println(modeloResponseBody.getCodigo());
        }
    }

    private AnoResponseBody[] buscarAno(int codigoMarca, int codigoModelo) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("parallelum.com.br")
                .path("fipe/api/v1/carros/marcas/")
                .path(String.valueOf(codigoMarca))
                .path("/modelos/")
				.path(String.valueOf(codigoModelo))
				.path("/anos")
                .build();
        System.out.println("URI Ano: " + uri.toUriString());
        ResponseEntity<AnoResponseBody[]> responseEntityAno = restTemplate.getForEntity(uri.toUriString(), AnoResponseBody[].class);
        AnoResponseBody[] anosArray = responseEntityAno.getBody();
//        imprimirAno(anosArray);
        return anosArray;
    }

    private String buscaCodigoAnoByNome(AnoResponseBody[] anosArray, int anoPostman) throws MarcaNotFoundException {
        for (AnoResponseBody anoResponseBody : anosArray) {
            String anoFipeComNome = anoResponseBody.getNome();
            String anoFipeSozinho = converterCodigoAnoFipeToAno(anoFipeComNome);
            if (anoFipeSozinho.equalsIgnoreCase(String.valueOf(anoPostman))) {
                return anoResponseBody.getCodigo();
            }
        }
        throw new MarcaNotFoundException();
    }

    public String converterCodigoAnoFipeToAno(String anoFipeComNome) {
        String[] anoFipeComNomeDividido = anoFipeComNome.split(" ");
        return anoFipeComNomeDividido[0];
    }

    private void imprimirAno(AnoResponseBody[] anosArray) {
        for (AnoResponseBody a : anosArray) {
            System.out.println(a.getCodigo());
            System.out.println(a.getNome());
        }
    }

    private ValorResponseBody buscarValor(int codigoMarca, int codigoModelo, String codigoAno) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("parallelum.com.br")
                .path("fipe/api/v1/carros/marcas/")
                .path(String.valueOf(codigoMarca))
                .path("/modelos/")
                .path(String.valueOf(codigoModelo))
                .path("/anos/")
                .path(codigoAno)
                .build();
        System.out.println("URI Valor: " + uri.toUriString());
        ResponseEntity<ValorResponseBody> responseEntityValor = restTemplate.getForEntity(uri.toUriString(), ValorResponseBody.class);
        ValorResponseBody valorResponseBody = responseEntityValor.getBody();
//        imprimirValorResponseBody(valorResponseBody);
        return valorResponseBody;
    }

    private void imprimirValorResponseBody(ValorResponseBody valorResponseBody) {
        System.out.println(valorResponseBody.toString());
    }

}
