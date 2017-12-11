package com.example.jkosterman6222.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import java.util.List;

public class LoginScreen extends AppCompatActivity {
    private User user;
    private WelcomeToast welcomeToast;
    private AppDatabase database;
    private String test;
    //public static final String CURRENTUSER = "currentUser";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_login_screen);

        database = AppDatabase.getDatabase(getApplicationContext());

        //database.userDao().removeAllUsers();

        List<User> users = database.userDao().getAllUser();
        if (users.isEmpty()) {

            //Some Dummy Data
            database.userDao().addUser(new User("JacKos", "Jacob", "Kosterman", "test@test.com","test"));
            database.userDao().addUser(new User("Newman123", "Bob", "Newman", "test@test.com", "test"));
            database.welcomeToastDao().addWelcomeToast(new WelcomeToast("Welcome Toast", "Welcome"));
            database.preferencesDao().addPreferences(new Preferences(1, "test@email.com", Boolean.TRUE));
        }

        List<WelcomeToast> welcomeToasts = database.welcomeToastDao().getAllWelcomeToast();
        test = welcomeToasts.get(0).comment.toString();
        Toast.makeText(this, test, Toast.LENGTH_SHORT).show();


        Button btnLogin = (Button)findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("CURRENTUSER", 0);
                /*SharedPreferences.Editor editor = preferences.edit();
                //editor.putInt("user", )*/


                    EditText userName;
                    EditText passWord;

                    userName = (EditText)findViewById(R.id.editText);
                    passWord = (EditText)findViewById(R.id.editText2);

                    String usernameCheck = userName.getText().toString();
                    String passwordCheck = passWord.getText().toString();

                    List<User> users = database.userDao().getUser(usernameCheck);

                    if( !users.isEmpty() && passwordCheck.equals(users.get(0).getPassword())){

                        String userId = users.get(0).userName;
                        SharedPreferences userPreferences = getSharedPreferences("CURRENTUSER", 0);
                        SharedPreferences.Editor editor = userPreferences.edit();
                        editor.putString("currentUser", userId);
                        editor.commit();

                        Intent intent = new Intent(getApplicationContext(), MainPage.class);
                        startActivity(intent);
                        //finish();
                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginScreen.this);
                        builder.setMessage("Please fill out valid Username and Password");
                        builder.setTitle("Login Error");
                        AlertDialog dialog = builder.create();
                        builder.create();
                        builder.show();
                        userName.setText("");
                        passWord.setText("");
                    }
                }

        });


    }
    /*private void updateFirstUserData() {
        List<User> user = database.userDao().getAllUser();
        List<Preferences> preferencesForUser = database.preferencesDao().findPreferencesForUser(user.get(0).id);
        //TextView textView = findViewById(R.id.result);
        //Toast.makeText(this, preferencesForUser.toString(), Toast.LENGTH_SHORT).show();
 }
*/

@Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }


    //Authenticate is dated and will be removed
   /* public void authenticate(View view) {
        EditText userName;
        EditText passWord;

        userName = (EditText)findViewById(R.id.editText);
        passWord = (EditText)findViewById(R.id.editText2);

        String usernameCheck = userName.getText().toString();
        String passwordCheck = passWord.getText().toString();

        List<User> users = database.userDao().getUser(usernameCheck);

        if( !users.isEmpty() && passwordCheck.equals(users.get(0).getPassword())){


            int userId = users.get(0).id;

            SharedPreferences mSettings = getSharedPreferences("Settings", 0);
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putInt("currentUser", userId);
            editor.commit();

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
*/
    public void createUser(View view) {

        Intent intent = new Intent(this, CreateUserPage.class);
        startActivity(intent);
    }

}


