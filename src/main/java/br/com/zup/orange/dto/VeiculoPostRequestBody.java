package br.com.zup.orange.dto;

import javax.validation.constraints.*;

public class VeiculoPostRequestBody {

    @NotBlank(message = "Marca é obrigatória")
    private String marca;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    @NotNull(message = "Ano é obrigatório")
    @Positive(message = "Ano deve ser positivo")
    @Min(value = 1884, message = "Ano não pode ser anterior a 1884")
    @Max(value = 2021, message = "Ano não pode ser posterior a 2021")
    private int ano;

    private Long usuarioId;

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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
