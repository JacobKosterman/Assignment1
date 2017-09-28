package com.example.jkosterman6222.assignment1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    public void authenticate(View view) {
        EditText userName;
        EditText passWord;

        String savedPassword = "12345";
        String savedUserName = "Max Power";

        String errorString = "";

        userName = (EditText)findViewById(R.id.editText);
        passWord = (EditText)findViewById(R.id.editText2);


        if(!userName.getText().toString().equals("") && !passWord.getText().toString().equals("")){

            if (userName.getText().toString().toUpperCase().equals(savedUserName.toUpperCase()) && passWord.getText().toString().equals(savedPassword.toUpperCase())){

                Intent intent = new Intent(this, MainPage.class);
                startActivity(intent);

            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Please fill out valid Username and Password");
                builder.setTitle("Login Error");
                AlertDialog dialog = builder.create();
                builder.create().show();
                userName.setText("");
                passWord.setText("");

            };

        }
    }
}
