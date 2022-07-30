package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginWindow extends AppCompatActivity {

    TextView username;
    TextView password;
    LoginValidator loginValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_window);
        username = (TextView) findViewById(R.id.editTextUsername);
        password = (TextView) findViewById(R.id.editTextPassword);
        loginValidator = LoginValidator.getInstance(this.getApplicationContext());
    }

    public void loginPressed(View view) {
        // Here we check if user has filled both username and password. Then we check if they are
        // correct by passing them into loginValidator class. With correct password we will head to
        // MainActivity class

        if (TextUtils.isEmpty(username.getText()) == false
                && TextUtils.isEmpty(password.getText()) == false){
            String usernameString = username.getText().toString();
            String passwordString = password.getText().toString();

            if (loginValidator.isValid(usernameString, passwordString) == true) {
                Intent i = new Intent(this, MainActivity.class); // to the MainActivity
                startActivity(i);
            }
        } else {
            Toast.makeText(getApplicationContext(), "Username or password is wrong!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void createAccount(View view) {
        // user can create account in new activity (NOT WORKING!!)
        Intent i = new Intent(this, CreateNewAccount.class);
        startActivity(i);
    }
}

