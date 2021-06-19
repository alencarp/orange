package br.com.zup.orange.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioPostRequestBody {
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "É obrigatório ser um e-mail.")
    private String email;
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    @NotBlank(message = "Data de nascimento é obrigatória")
    private String dataNascimento;

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
        return "UsuarioPostRequestBody{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
