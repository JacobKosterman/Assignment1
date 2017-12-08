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
    private WelcomeToast welcomeToast;
    private AppDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_login_screen);

        database = AppDatabase.getDatabase(getApplicationContext());

        //database.userDao().removeAllUsers();
        // add some data
        List<User> users = database.userDao().getAllUser();
        if (users.isEmpty()) {

            database.preferencesDao().addPreferences(new Preferences(user.id, "test@email.com", Boolean.TRUE));

            database.userDao().addUser(new User("JacKos", "Jacob", "Kosterman", "test@test.com","test"));
            database.userDao().addUser(new User("Newman123", "Bob", "Newman", "test@test.com", "test"));
            database.userDao().addUser(new User("Metzen", "Chris", "Metzen", "test@test.com", "test"));


            database.welcomeToastDao().addWelcomeToast(new WelcomeToast("Welcome Toast", "Welcome"));

            welcomeToastDao().getAllWelcomeToast().get(0);

            user = database.userDao().getAllUser().get(0);
            Toast.makeText(this, String.valueOf(user.userName), Toast.LENGTH_SHORT).show();

        }

        try{
            database.welcomeToastDao().getWelcomeToast(1);
        }
        catch (Exception e){

        }

        updateFirstUserData();
    }
    private void updateFirstUserData() {
        List<User> user = database.userDao().getAllUser();
        List<Preferences> preferencesForUser = database.preferencesDao().findPreferencesForUser(user.get(0).id);
        //TextView textView = findViewById(R.id.result);
        //Toast.makeText(this, preferencesForUser.toString(), Toast.LENGTH_SHORT).show();
       /* if (user.size()>0){
            textView.setText(user.get(0).name + " Skill points " + user.get(0).skillPoints + " Trophys " + trophiesForUser.size() );
        }*/
    }

    public void onClick(View view){
        /*if (view.getId()==R.id.addtrophybutton) {
            // TODO add trophy
            // TODO call updatefirstUserData
            Toast.makeText(this,String.valueOf(user.id), Toast.LENGTH_SHORT).show();
           //database.trophyDao().addTrophy(trophy);
        }
        if (view.getId()==R.id.increaseskills ){
            user.skillPoints++;
            database.userDao().updateUser(user);
            // TODO to skillpoints

        }
        // TODO call updatefirstUserData
        //updateFirstUserData();*/

    }
    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }


    //Authenticate is dated and will be removed
    public void authenticate(View view) {
        EditText userName;
        EditText passWord;

        userName = (EditText)findViewById(R.id.editText);
        passWord = (EditText)findViewById(R.id.editText2);

        String usernameCheck = userName.getText().toString();
        String passwordCheck = passWord.getText().toString();

        List<User> users = database.userDao().getUser(usernameCheck);

        if( !users.isEmpty() && passwordCheck.equals(users.get(0).getPassword())){

            Intent intent = new Intent(this, MainPage.class);
            startActivity(intent);
            finish();
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Please fill out valid Username and Password");
            builder.setTitle("Login Error");
            AlertDialog dialog = builder.create();
            builder.create().show();
            userName.setText("");
            passWord.setText("");
        }
    }



    /*
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

*/

    public void createUser(View view) {

        Intent intent = new Intent(this, CreateUserPage.class);
        startActivity(intent);
    }


}


