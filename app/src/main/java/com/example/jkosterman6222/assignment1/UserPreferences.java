package com.example.jkosterman6222.assignment1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

public class UserPreferences extends AppCompatActivity {

    public String CurrentUser = "";
    private AppDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preferences);


        database = AppDatabase.getDatabase(getApplicationContext());
        String userString = getIntent().getStringExtra("CURRENT_USER");
        List<User> currentUser = database.userDao().getUser(userString);

        if( !currentUser.isEmpty() ){

            int tempUserInt = currentUser.get(0).id;

            List<Preferences> currentUserPref = database.preferencesDao().findPreferencesForUser(tempUserInt);


            RadioButton radBut = findViewById(R.id.radioReceipt);
            EditText emailText = findViewById(R.id.emailText);
            emailText.setVisibility(View.INVISIBLE);


            if( !currentUserPref.isEmpty()){

                Preferences pref = currentUserPref.get(0);

                boolean userChoice = pref.pettyCash;

                if (userChoice == true){
                    radBut.setChecked(true);
                    emailText.setText(pref.emailString);
                    emailText.setVisibility(View.VISIBLE);

                }else{
                    radBut.setChecked(false);
                    emailText.setText("");
                    emailText.setVisibility(View.INVISIBLE);
                }
            }
        }
        CurrentUser = userString;

    }

    public void SaveChanges(View view){

        RadioButton radReceipt = findViewById(R.id.radioReceipt);
        RadioButton radPetty = findViewById(R.id.radioPettyCash);
        RadioGroup radGroup = findViewById(R.id.radioGroup);
        EditText emailText = findViewById(R.id.emailText);


        if (radGroup.getCheckedRadioButtonId()== -1){

            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            builder.setMessage("Please select a use for the app");
            builder.setTitle("Unable to Save Changes");
            AlertDialog dialog = builder.create();
            builder.create();
            builder.show();

        }else{

            //database = AppDatabase.getDatabase(getApplicationContext());
            List<User> TempUser = database.userDao().getUser(CurrentUser);
            int tempUser = TempUser.get(0).id;

            List<Preferences> userPrefs = database.preferencesDao().findPreferencesForUser(tempUser);

            if (!userPrefs.isEmpty()){

                Preferences pref = userPrefs.get(0);

                if (radReceipt.isChecked() == true){

                    pref.pettyCash = Boolean.FALSE;
                    pref.emailString = "";

                    database.preferencesDao().updatePreferences(userPrefs.get(0));

                }else{
                    pref.pettyCash = Boolean.TRUE;
                    pref.emailString = emailText.getText().toString();

                    database.preferencesDao().updatePreferences(userPrefs.get(0));
                }

            }
            else
            {
                Preferences addPref = new Preferences(tempUser, "", Boolean.FALSE);
                String tempString = emailText.getText().toString();

                if (radPetty.isChecked()){
                    addPref.pettyCash = Boolean.TRUE;
                }

                if (tempString != ""){
                    addPref.emailString = tempString;
                }

                database.preferencesDao().addPreferences(addPref);
            }

        }
    }

    public void btnSMSClick(View v){

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(intent);

    }


    public void btnChromeStart(View v){

        String url = "http://www.example.com";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setPackage("com.android.chrome");
        try {
            startActivity(i);
        } catch (ActivityNotFoundException e) {
            // Chrome is probably not installed
            // Try with the default browser
            i.setPackage(null);
            startActivity(i);
        }

    }


    public void ShowEmail(View view){

        boolean checked = ((RadioButton) view).isChecked();
        EditText emailText = findViewById(R.id.emailText);


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
