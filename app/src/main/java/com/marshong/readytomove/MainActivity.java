package com.marshong.readytomove;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button fromButton;
    Button toButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromButton = (Button) findViewById(R.id.fromButtonMain);
        toButton = (Button) findViewById(R.id.toButtonMain);

        processFromActivity();
    }


    private void processFromActivity() {
        fromButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we want to open up the From Main Activity Page
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FromMainActivity.class);
                startActivity(intent);
            }
        });
    }

}
