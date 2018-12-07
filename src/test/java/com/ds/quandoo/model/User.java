package com.ds.quandoo.model;

import com.ds.quandoo.util.DataFaker;
import java.util.Base64;

public class User {

    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public User setUserCredentials(String userName, String password) {
        setUserName(new String(Base64.getDecoder().decode(userName)));
        setPassword(new String(Base64.getDecoder().decode(password)));
        return this;
    }

    public User getCorrectCredentials() {
        return this;
    }

    public User getCredentialsWithIncorrectUserName() {
        setUserName(DataFaker.getNewUserName());
        return this;
    }

    public User getCredentialsWithIncorrecPassword() {
        setPassword(DataFaker.getNewPassword());
        return this;
    }

    private String userName;
    private String password;
}
