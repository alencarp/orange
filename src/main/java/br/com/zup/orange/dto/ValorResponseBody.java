package br.com.zup.orange.dto;

public class ValorResponseBody {
    /*
    "Valor": "R$ 3.055,00",
"Marca": "Ford",
"Modelo": "Corcel II GL/GT",
"AnoModelo": 1986,
"Combustivel": "Gasolina",
"CodigoFipe": "003129-1",
"MesReferencia": "junho de 2021 ",
"TipoVeiculo": 1,
"SiglaCombustivel": "G"
     */

    private String Valor;
    private String Marca;
    private String Modelo;
    private int AnoModelo;
    private String Combustivel;
    private String CodigoFipe;
    private String MesReferencia;
    private int TipoVeiculo;
    private String SiglaCombustivel;

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getAnoModelo() {
        return AnoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        AnoModelo = anoModelo;
    }

    public String getCombustivel() {
        return Combustivel;
    }

    public void setCombustivel(String combustivel) {
        Combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return CodigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        CodigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return MesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        MesReferencia = mesReferencia;
    }

    public int getTipoVeiculo() {
        return TipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        TipoVeiculo = tipoVeiculo;
    }

    public String getSiglaCombustivel() {
        return SiglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        SiglaCombustivel = siglaCombustivel;
    }

    @Override
    public String toString() {
        return "ValorResponseBody{" +
                "Valor='" + Valor + '\'' +
                ", Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", AnoModelo=" + AnoModelo +
                ", Combustivel='" + Combustivel + '\'' +
                ", CodigoFipe='" + CodigoFipe + '\'' +
                ", MesReferencia='" + MesReferencia + '\'' +
                ", TipoVeiculo=" + TipoVeiculo +
                ", SiglaCombustivel='" + SiglaCombustivel + '\'' +
                '}';
    }
}
