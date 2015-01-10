package com.marshong.readytomove;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class FromMainActivity extends ActionBarActivity {

    Button backToMainButton;
    ImageButton imageBackHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_main);

        backToMainButton = (Button) findViewById(R.id.backToMainButton);
        imageBackHomeButton = (ImageButton) findViewById(R.id.backToHomeImageButton);

        processFromActivity();
    }

    private void processFromActivity() {

        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FromMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        imageBackHomeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FromMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
