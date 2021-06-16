package br.com.zup.orange.domain;

import javax.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private String valor;

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

    public void setValor(String valor) { this.valor = valor;    }

    public String getValor() {
        return valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void atribuiUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
