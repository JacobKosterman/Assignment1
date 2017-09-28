package com.example.jkosterman6222.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class UserPreferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preferences);
    }

    public void ShowEmail(View view){

        boolean checked = ((RadioButton) view).isChecked();
        EditText emailText = (EditText) findViewById(R.id.emailText);


        switch(view.getId()) {
            case R.id.radioPettyCash:
                if (checked)
                    emailText.setVisibility(View.VISIBLE);
                    break;

            case R.id.radioReceipt:
                if (checked)
                    emailText.setVisibility(View.INVISIBLE);
                    break;
        }
    }
}
