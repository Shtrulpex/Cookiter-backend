package ru.samsungitschool.sibirtsev.cookiter.entity;

public class Users {
    private Integer id;
    private String login;
    private Integer password;
    private String email;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public Integer getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
