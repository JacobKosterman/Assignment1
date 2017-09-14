package com.example.jkosterman6222.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    public void authenticate() {
        EditText userName;
        EditText passWord;

        String savedPassword = "12345";
        String savedUserName = "Max Power";

        String errorString = "";

        userName = (EditText)findViewById(R.id.editText);
        passWord = (EditText)findViewById(R.id.editText2);


        if(!userName.getText().toString().equals("") && !passWord.getText().toString().equals("")){

            if (userName.getText().toString().toUpperCase().equals(savedUserName.toUpperCase()) && passWord.getText().toString().equals(savedPassword.toUpperCase())){

                



            }
        }
    }
}
