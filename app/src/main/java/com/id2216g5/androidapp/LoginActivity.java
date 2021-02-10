package com.id2216g5.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {



    /* Define the layout elements */
    private EditText loginUsername;
    private EditText loginPassword;
    private Button loginButton;
    private Button registerButton;

    String userName = "";
    String userPassword = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /* Bind the XML views to Java Code Elements */
        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginbutton);
        registerButton = findViewById(R.id.registerbutton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Feature not available yet", Toast.LENGTH_LONG).show();
            }
        });

        /* Describe the logic when the login button is clicked */
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Obtain user inputs */
                userName = loginUsername.getText().toString();
                userPassword = loginPassword.getText().toString();

                /* Check if the user inputs are empty */
                if(userName.isEmpty() || userPassword.isEmpty())
                {
                    /* Display a message toast to user to enter the details */
                    Toast.makeText(LoginActivity.this, "Please enter name and password!", Toast.LENGTH_LONG).show();

                }else {


                    if(userName.equals("user") && userPassword.equals("password"))
                    {
                        /* Allow the user in to your app by going into the next activity */
                        startActivity(new Intent(LoginActivity.this, LobbyActivity.class));
                    }
                    /* Display error message */
                    else {
                        Toast.makeText(LoginActivity.this, "Incorrect username or password!", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}