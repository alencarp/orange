package br.com.zup.orange.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;

public class ValorResponseBody implements Serializable {

    @JsonSetter("Valor")
    private String valor;

    @JsonSetter("Marca")
    private String marca;

    @JsonSetter("Modelo")
    private String modelo;

    @JsonSetter("AnoModelo")
    private int anoModelo;

    @JsonSetter("Combustivel")
    private String combustivel;

    @JsonSetter("CodigoFipe")
    private String codigoFipe;

    @JsonSetter("MesReferencia")
    private String mesReferencia;

    @JsonSetter("TipoVeiculo")
    private int tipoVeiculo;

    @JsonSetter("SiglaCombustivel")
    private String siglaCombustivel;

    public String getValor() {
        return valor;
    }


    public void setValor(String valor) {
        this.valor = valor;
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

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public int getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        this.siglaCombustivel = siglaCombustivel;
    }

    @Override
    public String toString() {
        return "ValorResponseBody{" +
                "valor='" + valor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoModelo=" + anoModelo +
                ", combustivel='" + combustivel + '\'' +
                ", codigoFipe='" + codigoFipe + '\'' +
                ", mesReferencia='" + mesReferencia + '\'' +
                ", tipoVeiculo=" + tipoVeiculo +
                ", siglaCombustivel='" + siglaCombustivel + '\'' +
                '}';
    }
}
