package com.example.jkosterman6222.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ToastActivity extends AppCompatActivity {

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        database = AppDatabase.getDatabase(getApplicationContext());

        List<WelcomeToast> welcomeToastList = database.welcomeToastDao().getAllWelcomeToast();

        List<String> tempStringList = new ArrayList<String>();
        String tempComment = "";
        String tempName = "";
        String tempJoined = "";

        for (int i=0; i<welcomeToastList.size(); i++){
            tempComment = welcomeToastList.get(i).comment;
            tempName = welcomeToastList.get(i).name;
            tempJoined = tempName  + ": \n " + tempComment;

            tempStringList.add(tempJoined);
        }

        ListView listView = (ListView) findViewById(R.id.lstView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                tempStringList
        );
        listView.setAdapter(arrayAdapter);

    }

    public void btnViewToast(View view) {

        Intent intent = new Intent(this, AddToastActivity.class);
        startActivity(intent);
    }

}
