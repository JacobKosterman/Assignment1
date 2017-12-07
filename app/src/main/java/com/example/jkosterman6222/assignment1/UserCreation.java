package com.example.jkosterman6222.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserCreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation);
    }

    public void createUser(View view){



    }

    public void finalizeUser(View view){

        EditText EditFirstName;
        EditText EditLastName;
        EditText EditEmailAddress;
        EditText EditPassword;
        EditText EditPasswordCheck;

        String firstName = "";
        String lastName = "";
        String emailAddress = "";
        String password = "";
        String passwordCheck = "";

        EditFirstName =  (EditText)findViewById(R.id.txtFirstName);
        EditLastName =  (EditText)findViewById(R.id.txtLastName);
        EditEmailAddress =  (EditText)findViewById(R.id.txtEmail);
        EditPassword = (EditText)findViewById(R.id.txtPass);
        EditPasswordCheck = (EditText)findViewById(R.id.txtPassCheck);

        if(!userName.getText().toString().equals("") && !passWord.getText().toString().equals("")){




        }






    }
   /* public void authenticate(View view) {
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
    }*/

}
