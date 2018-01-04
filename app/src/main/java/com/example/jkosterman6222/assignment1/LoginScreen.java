package com.example.jkosterman6222.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import java.io.InputStream;
import java.util.List;

public class LoginScreen extends AppCompatActivity {
    private User user;
    private WelcomeToast welcomeToast;
    private AppDatabase database;
    private String test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_login_screen);

        database = AppDatabase.getDatabase(getApplicationContext());

        new DownloadImageTask((ImageView) findViewById(R.id.imageView2))
                .execute("https://img00.deviantart.net/497d/i/2011/247/3/1/vector_zerg_logo_by_elrondsmith-d48th8f.png");



        //database.userDao().removeAllUsers();

        List<User> users = database.userDao().getAllUser();
        if (users.isEmpty()) {

            //Some Dummy Data
            database.userDao().addUser(new User("JacKos", "Jacob", "Kosterman", "test@test.com","test"));
            database.userDao().addUser(new User("Newman", "Bob", "Newman", "test@test.com", "test"));
            database.welcomeToastDao().addWelcomeToast(new WelcomeToast("Morning Toast", "Good Morning"));
            database.welcomeToastDao().addWelcomeToast(new WelcomeToast("Afternoon Toast", "Good Afternoon"));
            database.welcomeToastDao().addWelcomeToast(new WelcomeToast("Evening Toast", "Good Evening"));
            database.welcomeToastDao().addWelcomeToast(new WelcomeToast("Late Toast", "Go to bed!"));
            database.preferencesDao().addPreferences(new Preferences(1, "test@email.com", Boolean.TRUE));
            database.preferencesDao().addPreferences(new Preferences(2, "test@test.com", Boolean.FALSE));
        }

        List<WelcomeToast> welcomeToasts = database.welcomeToastDao().getAllWelcomeToast();
        test = welcomeToasts.get(1).comment.toString();
        Toast.makeText(this, test, Toast.LENGTH_SHORT).show();

        Button btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                    EditText userName;
                    EditText passWord;

                    userName = findViewById(R.id.editText);
                    passWord = findViewById(R.id.editText2);

                    String usernameCheck = userName.getText().toString();
                    String passwordCheck = passWord.getText().toString();

                    List<User> users = database.userDao().getUser(usernameCheck);

                    if( !users.isEmpty() && passwordCheck.equals(users.get(0).getPassword())){

                                               String userId = users.get(0).userName;
                        Intent intent = new Intent(getApplicationContext(), MainPage.class);
                        intent.putExtra("CURRENT_USER", userId);
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

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    public void createUser(View view) {

        Intent intent = new Intent(this, CreateUserPage.class);
        startActivity(intent);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}


