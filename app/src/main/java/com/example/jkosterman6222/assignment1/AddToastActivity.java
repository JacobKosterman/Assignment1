package com.example.jkosterman6222.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddToastActivity extends AppCompatActivity {

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_toast);


       // database = AppDatabase.getDatabase(getApplicationContext());

//        EditText toastEditName;
//        EditText toastEditComment;
//
//        String toastName = "";
//        String toastComment = "";
//
//        toastEditName = (EditText)findViewById(R.id.txtToastName);
//        toastEditComment = (EditText)findViewById(R.id.txtToastComment);
//
//
//        toastName = toastEditName.getText().toString();
//        toastComment = toastEditComment.getText().toString();
//
//        if(!toastEditName.getText().toString().equals("")
//                && !toastEditComment.getText().toString().equals("")){
//
//            database.welcomeToastDao().addWelcomeToast(new WelcomeToast(toastName, toastComment));
//
//            Intent intent = new Intent(this, MainPage.class);
//            startActivity(intent);
//
//        }

    }
    public void btnSaveToast(View view){

        database = AppDatabase.getDatabase(getApplicationContext());

        EditText toastEditName;
        EditText toastEditComment;

        String toastName = "";
        String toastComment = "";

        toastEditName = (EditText)findViewById(R.id.txtToastName);
        toastEditComment = (EditText)findViewById(R.id.txtToastComment);


        toastName = toastEditName.getText().toString();
        toastComment = toastEditComment.getText().toString();

        if(!toastEditName.getText().toString().equals("")
                && !toastEditComment.getText().toString().equals("")){

            database.welcomeToastDao().addWelcomeToast(new WelcomeToast(toastName, toastComment));

            Intent intent = new Intent(this, LoginScreen.class);
            startActivity(intent);
            finish();

        }

    }

}
