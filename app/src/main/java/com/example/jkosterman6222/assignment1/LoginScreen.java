package com.example.jkosterman6222.assignment1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import java.util.List;

public class LoginScreen extends AppCompatActivity {
    private User user;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_login_screen);




        database = AppDatabase.getDatabase(getApplicationContext());

        database.userDao().removeAllUsers();
        // add some data
        List<User> users = database.userDao().getAllUser();
        if (users.size()==0) {
            database.userDao().addUser(new User(1, "Test 1", 1));
            user = database.userDao().getAllUser().get(0);
            Toast.makeText(this, String.valueOf(user.id), Toast.LENGTH_SHORT).show();
            database.userDao().addUser(new User(2, "Test 2", 2));
            database.userDao().addUser(new User(3, "Test 3", 3));
        }
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


        public void onClick(View view){
           /* if (view.getId()==R.id.addtrophybutton) {
                // TODO add trophy
                // TODO call updatefirstUserData
                Toast.makeText(this,String.valueOf(user.id), Toast.LENGTH_SHORT).show();
               //database.trophyDao().addTrophy(trophy);
            }*/
           /* if (view.getId()==R.id.increaseskills ){
                user.skillPoints++;
                database.userDao().updateUser(user);
                // TODO to skillpoints

            }*/
            // TODO call updatefirstUserData
            //updateFirstUserData();

        }
        @Override
        protected void onDestroy() {
            AppDatabase.destroyInstance();
            super.onDestroy();
        }
    }


