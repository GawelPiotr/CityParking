package com.parking.parking.Model;


import javax.persistence.*;

@Entity
@Table(name = "operator")
public class Operator {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "operator_id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "paswword")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
