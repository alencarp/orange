package br.com.zup.orange.dto;

import br.com.zup.orange.domain.User;
import br.com.zup.orange.domain.Veiculo;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class UserPostRequestBody {

    private List<Veiculo> veiculos;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Is mandatory to be an e-mail")
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    @Column(table = "datanasc")
    private String dataNascimento;


    public UserPostRequestBody() {
    }

    public UserPostRequestBody(List<Veiculo> veiculos, String name, String email, String cpf, String dataNascimento) {
        this.veiculos = veiculos;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public User build() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setCpf(this.cpf);
        user.setDataNascimento(this.dataNascimento);
        user.setVeiculos(this.veiculos);
        return user;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "UserPostRequestBody{" +
                "veiculos=" + veiculos +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
