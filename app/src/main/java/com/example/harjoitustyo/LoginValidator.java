package com.example.harjoitustyo;

import android.content.Context;
import java.util.HashMap;

public class LoginValidator {

    private static LoginValidator instance = null;
    private HashMap<String, String> loginData = new HashMap<>();

    private LoginValidator() {}

    public static LoginValidator getInstance(Context applicationContext) {
        // here we create a singleton

        if (instance == null) {
            instance = new LoginValidator();
        }
        return instance;
    }

    public boolean createAccount(String username, String password) {
        // here we make a new account (Not working, since i was unable to save the data)

        if (loginData.containsKey(username) == false) {
            loginData.put(username, password);
            return true;
        }
        return false;
    }

    public boolean isValid(String usernameString, String passwordString) {
        // here we check if username and password is valid. "admin" and "123" is a put there as a
        // username password combo that works

        loginData.put("admin", "123");

        if (loginData.get(usernameString).equals(passwordString)) {
            return true;
        }
        return false;
    }
}
