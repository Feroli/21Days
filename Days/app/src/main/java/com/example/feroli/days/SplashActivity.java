package com.example.feroli.days;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView tv = (TextView) findViewById(R.id.phrase);

        String[] phrases = new String[] {"Develop one habit at a time.", "Keep your new habit small.", "Commit to your new habit for three weeks.", "Concentrate on starting.","Recognize the positive in what you’re doing.","Don’t miss two days in a row." };

        int index = new Random().nextInt(phrases.length);

        tv.setText(phrases[index]);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }


}
