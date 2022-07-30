package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CreateNewAccount extends AppCompatActivity {
    //this class is not working, since i had problems with saving data outside activity classes.

    TextView username;
    TextView password;
    TextView password2;
    LoginValidator loginValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);

        username = (TextView) findViewById(R.id.usernameText);
        password = (TextView) findViewById(R.id.password);
        password2 = (TextView) findViewById(R.id.password2);
    }

    public void createAccount(View view){
        // here we check if we can create new account or not

        if (TextUtils.isEmpty(username.getText()) == false
                && TextUtils.isEmpty(password.getText()) == false
                && TextUtils.isEmpty(password2.getText()) == false) {
            String usernameString = username.getText().toString();
            String passwordString = password.getText().toString();
            String passwordString2 = password2.getText().toString();

            if (passwordString.equals(passwordString2)) {
                if (loginValidator.createAccount(usernameString, passwordString) == true) {
                    Toast.makeText(getApplicationContext(),
                            "Account created!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Username is taken. Try another username.",
                            Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(),
                        "Passwords don't match.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(),
                    "Some input is missing.", Toast.LENGTH_SHORT).show();
        }
    }
}