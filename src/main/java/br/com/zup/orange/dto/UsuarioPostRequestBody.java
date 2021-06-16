package br.com.zup.orange.dto;

import br.com.zup.orange.domain.Usuario;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioPostRequestBody {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Is mandatory to be an e-mail")
    @Column(unique = true)
    private String email;


    public UsuarioPostRequestBody() {
    }

    public UsuarioPostRequestBody(String name, String email) {

        this.name = name;
        this.email = email;
    }

    public Usuario build() {
        Usuario usuario = new Usuario();
        usuario.setNome(this.name);
        usuario.setEmail(this.email);
        return usuario;
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



    @Override
    public String toString() {
        return "UserPostRequestBody{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
