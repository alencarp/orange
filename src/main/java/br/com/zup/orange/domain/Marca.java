package br.com.zup.orange.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Marca {

    @Id
    private int codigo;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}

