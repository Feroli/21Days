package com.example.feroli.days;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.github.mikephil.charting.charts.PieChart;

import com.lylc.widget.circularprogressbar.CircularProgressBar;
import com.melnykov.fab.FloatingActionButton;


public class MainActivity extends AppCompatActivity{

    String addGoalInput;
    protected String[] mParties = new String[] {
            "Uno", "Dos", "Tres"
    };

    private PieChart mChart;

    private CircularProgressBar mCProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View goalInfo = findViewById(R.id.goalinfo);


        goalInfo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("¿Deseas borrar tu objetivo actual?");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Se elimina


                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
                return false;
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Title");

//                /final EditText input = new EditText(MainActivity.this);
//                input.setInputType(InputType.TYPE_CLASS_TEXT);
//                builder.setView(input);*/

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //addGoalInput = input.getText().toString();
                        mCProgress.setProgress(mCProgress.getProgress()+5);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });

        mCProgress = (CircularProgressBar) findViewById(R.id.circularprogressbar1);
        mCProgress.setProgress(5);
        mCProgress.setTitle("Tarea");
        mCProgress.setSubTitle("");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

}
