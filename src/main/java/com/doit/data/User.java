package com.doit.data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "err.field.name.required")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "err.field.surname.required")
    @Column(name = "surname")
    private String surname;

    @Email(message = "{err.field.email.invalid}")
    @NotEmpty(message = "{err.field.email.required}")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User() {}

    public User(User user) {
        this.id = user.id;
        this.name = user.name;
        this.surname = user.surname;
        this.email = user.email;
        this.password = user.password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

