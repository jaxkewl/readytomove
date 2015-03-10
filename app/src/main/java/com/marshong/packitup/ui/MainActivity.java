package com.marshong.packitup.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.marshong.packitup.R;


public class MainActivity extends ActionBarActivity {

    Button fromButton;
    Button toButton;
    Button mButtonStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromButton = (Button) findViewById(R.id.fromButtonMain);
        toButton = (Button) findViewById(R.id.toButtonMain);


        // process Box Activity
        mButtonStorage = (Button) findViewById(R.id.buttonBox);
        mButtonStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StorageListActivity.class);
                startActivity(intent);
            }
        });

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // start this activity
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
