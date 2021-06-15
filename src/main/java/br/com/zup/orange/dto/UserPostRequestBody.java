package br.com.zup.orange.dto;

import br.com.zup.orange.domain.User;
import br.com.zup.orange.domain.Veiculo;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class UserPostRequestBody {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Is mandatory to be an e-mail")
    @Column(unique = true)
    private String email;


    public UserPostRequestBody() {
    }

    public UserPostRequestBody(String name, String email) {

        this.name = name;
        this.email = email;
    }

    public User build() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        return user;
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
