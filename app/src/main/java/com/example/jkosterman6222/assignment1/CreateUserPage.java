package com.example.jkosterman6222.assignment1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class CreateUserPage extends AppCompatActivity {

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation);
        database = AppDatabase.getDatabase(getApplicationContext());
    }


    public void finalizeUser(View view){

        EditText EditUsername;
        EditText EditFirstName;
        EditText EditLastName;
        EditText EditEmailAddress;
        EditText EditPassword;
        EditText EditPasswordCheck;

        String username = "";
        String firstName = "";
        String lastName = "";
        String emailAddress = "";
        String password = "";
        String passwordCheck = "";

        EditUsername = (EditText)findViewById(R.id.txtUserName);
        EditFirstName =  (EditText)findViewById(R.id.txtFirstName);
        EditLastName =  (EditText)findViewById(R.id.txtLastName);
        EditEmailAddress =  (EditText)findViewById(R.id.txtEmail);
        EditPassword = (EditText)findViewById(R.id.txtPass);
        EditPasswordCheck = (EditText)findViewById(R.id.txtPassCheck);

        username = EditUsername.getText().toString();
        firstName = EditFirstName.getText().toString();
        lastName = EditLastName.getText().toString();
        emailAddress = EditEmailAddress.getText().toString();
        password = EditPassword.getText().toString();
        passwordCheck = EditPasswordCheck.getText().toString();

        if(!EditFirstName.getText().toString().equals("") && !EditLastName.getText().toString().equals("") && !EditUsername.getText().toString().equals("")
                && !EditEmailAddress.getText().toString().equals("") && !EditPassword.getText().toString().equals("") && !EditPasswordCheck.getText().toString().equals("")){

            if(password.equals(passwordCheck)) {

                //Put database code for adding user
                List<User> users = database.userDao().getUser(username);

                if(users.isEmpty()){
                    database.userDao().addUser(new User(username, firstName, lastName, emailAddress, password));

                    Intent intent = new Intent(this, LoginScreen.class);
                    startActivity(intent);
                    finish();
                }
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Passwords do not match");
                builder.setTitle("User Creation Error");
                AlertDialog dialog = builder.create();
                builder.create().show();
            }
        }
        else{

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Please Fill out all fields");
            builder.setTitle("User Creation Error");
            AlertDialog dialog = builder.create();
            builder.create().show();

        }
    }
}




