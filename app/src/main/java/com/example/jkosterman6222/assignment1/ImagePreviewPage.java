package com.example.jkosterman6222.assignment1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ImagePreviewPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview_page);
    }

    public void captureImage (View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Picture Has Been Taken");
        AlertDialog dialog = builder.create();
        builder.create().show();

    };

}
