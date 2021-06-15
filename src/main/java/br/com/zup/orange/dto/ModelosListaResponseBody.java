package br.com.zup.orange.dto;

import java.util.List;

public class ModelosListaResponseBody {
    List<ModeloResponseBody> modelos;
    List<AnoResponseBody> anos;

    public List<ModeloResponseBody> getModelos() {
        return modelos;
    }

    public void setModelos(List<ModeloResponseBody> modelos) {
        this.modelos = modelos;
    }

    public List<AnoResponseBody> getAnos() {
        return anos;
    }

    public void setAnos(List<AnoResponseBody> anos) {
        this.anos = anos;
    }
}
