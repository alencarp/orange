package br.com.zup.orange.requests;

import br.com.zup.orange.domain.Veiculo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VeiculoPostRequestBody {
    @NotBlank(message = "Marca é obrigatória")
    private String marca;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    @NotNull(message = "Ano é obrigatório")
    private int ano;

    public VeiculoPostRequestBody(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public VeiculoPostRequestBody() {
    }

    public Veiculo build() {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(this.marca);
        veiculo.setModelo(this.modelo);
        veiculo.setAno(this.ano);
        return veiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
