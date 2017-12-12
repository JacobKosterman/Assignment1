package com.example.jkosterman6222.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    public static final String CURRENTUSER = "myPreferencesFile";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        TextView tv = (TextView)findViewById(R.id.txtTest);
        SharedPreferences example = getSharedPreferences(CURRENTUSER, 0);
        String userString = example.getString("currentUser", "Not Found");
        tv.setText(userString);

        //String s = getIntent().getStringExtra("CURRENT_USER");
        //tv.setText(s);

    }

    @Override
    public void onBackPressed() {
        setContentView(R.layout.activity_main_page);

        TextView tv = (TextView)findViewById(R.id.txtTest);
        //SharedPreferences example = getSharedPreferences(CURRENTUSER, 0);
        //String userString = example.getString("currentUser", "Not Found");


        String s = getIntent().getStringExtra("CURRENT_USER");
        tv.setText(s);

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




