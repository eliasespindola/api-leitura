package br.com.me.apileitura.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Email
    @NotBlank
    private String email;

    public User(String email) {
        this.email = email;
    }

    @Deprecated
    protected User() {}

    public Long getId() {
        return id;
    }
}
