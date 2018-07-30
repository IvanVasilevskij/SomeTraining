package com.sqldatabaseandnosql.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CustomerForm {
    @NotEmpty
    @Size(min = 2, max = 25)
    private String login;
    @NotEmpty
    @Size(min = 6, max = 25)
    private String password;
    @Size(min = 6, max = 25)
    private String newPassword;
    private String firstName;
    private String lastName;
    @NotEmpty
    private String city;
    private int age;

    public String getLogin() {
        return login;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
