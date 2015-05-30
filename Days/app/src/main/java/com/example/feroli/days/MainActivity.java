package com.example.feroli.days;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner studySpin;
    ArrayList<String> goals;
    ProgressBar studyPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studyPro = (ProgressBar) findViewById(R.id.studyPro);
        studyPro.setIndeterminate(false);





        studySpin = (Spinner) findViewById(R.id.studySpin);
        goals = new ArrayList<String>(2);
        goals.add("Study");
        goals.add("Learn");

        ArrayAdapter<String> objAdap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, goals);
        studySpin.setAdapter(objAdap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}
