package br.com.zup.orange.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String marca;
    @Column(nullable=false)
    private String modelo;
    @Column(nullable=false)
    private int ano;
    private String valor;
    @Column(name="dia_rodizio")
    private String diaRodizio;
    @Column(name="is_rodizio_ativo")
    private boolean isRodizioAtivo;
    @JsonIgnore
    @JoinColumn(name = "usuario_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    public Veiculo() {
    }

    public Veiculo(Long id, String marca, String modelo, int ano, String valor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDiaRodizio() {
        return diaRodizio;
    }

    public void setDiaRodizio(String diaRodizio) {
        this.diaRodizio = diaRodizio;
    }

    public boolean isRodizioAtivo() {
        return isRodizioAtivo;
    }

    public void setRodizioAtivo(boolean rodizioAtivo) {
        isRodizioAtivo = rodizioAtivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void atribuiUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", valor='" + valor + '\'' +
                ", diaRodizio='" + diaRodizio + '\'' +
                ", isRodizioAtivo=" + isRodizioAtivo +
                ", usuario=" + usuario +
                '}';
    }
}
