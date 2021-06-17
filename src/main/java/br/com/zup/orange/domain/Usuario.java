package br.com.zup.orange.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
//    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private Set<Veiculo> veiculos = new HashSet<>();

    public Usuario() {
    }

//    public Usuario(long id, String nome, String email) {
//        this.id = id;
//        this.nome = nome;
//        this.email = email;
//    }

    public Usuario(long id, String nome, String email, Set<Veiculo> veiculos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.veiculos = veiculos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", veiculos=" + veiculos +
                '}';
    }

//    public void atribuirVeiculo(Veiculo veiculo) {
//        this.veiculos.add(veiculo);
//    }
}
