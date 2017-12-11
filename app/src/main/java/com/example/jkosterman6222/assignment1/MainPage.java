package com.example.jkosterman6222.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    public static final String CURRENTUSER = "currentUser";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        TextView tv = (TextView)findViewById(R.id.txtTest);

        SharedPreferences example = getSharedPreferences(CURRENTUSER, 0);

        String userString = example.getString("currentUser", "Not Found");

        tv.setText(userString);


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




