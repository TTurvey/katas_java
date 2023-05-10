package org.example.passwordValidation;

public class PasswordValidator {


    public Boolean check(String password) {
        return password.length() >= 8;
    }

}
