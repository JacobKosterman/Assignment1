package com.example.jkosterman6222.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainPage extends AppCompatActivity {

    public static final String PREFS = "examplePrefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);




    }

    public void TakePicture(View view) {

            Intent intent = new Intent(this, ImagePreviewPage.class);
            startActivity(intent);
        }

    public void UserPreferences(View view) {


            Intent intent = new Intent(this, UserPreferences.class);
            startActivity(intent);
        }

    }




