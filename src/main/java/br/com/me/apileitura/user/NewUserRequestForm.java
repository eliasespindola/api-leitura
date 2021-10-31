package br.com.me.apileitura.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NewUserRequestForm {

    @Email(message = "The email cannot be empty")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    public User toModel(){
        return new User(this.email);
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
