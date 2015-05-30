package com.example.feroli.days;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner studySpin;
    ArrayList<String> goals;
    ProgressBar studyPro;

    ListView mListGoals;
    ArrayList<Goal> mGoalsList;
    String addGoalInput;
    GoalsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListGoals = (ListView) findViewById(R.id.goalslist);

        Goal[] goals = new Goal[] { new Goal("hola", 3), new Goal("hola", 13), new Goal("hola", 21),
                new Goal("hola", 3), new Goal("hola", 13), new Goal("hola", 21),
                new Goal("hola", 3), new Goal("hola", 13), new Goal("hola", 21),
                new Goal("hola", 3), new Goal("hola", 13), new Goal("hola", 21),
                new Goal("hola", 3), new Goal("hola", 13), new Goal("hola", 21),
                new Goal("hola", 3), new Goal("hola", 13), new Goal("hola", 21)};

        mGoalsList = new ArrayList<>();
        for (int i = 0; i < goals.length; ++i) {
            mGoalsList.add(goals[i]);
        }

        mAdapter = new GoalsAdapter(this, mGoalsList);
        mListGoals.setAdapter(mAdapter);

        mListGoals.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Title" + position);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mGoalsList.remove(position);
                        mAdapter.notifyDataSetChanged();

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
        fab.attachToListView(mListGoals);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Title");

                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addGoalInput = input.getText().toString();
                        mGoalsList.add(new Goal(addGoalInput, 0));
                        mAdapter.notifyDataSetChanged();
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

    public class GoalsAdapter extends ArrayAdapter<Goal> {
        public GoalsAdapter(Context context, ArrayList<Goal> goals) {
            super(context, 0, goals);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Goal goal = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.goalrow, parent, false);
            }
            // Lookup view for data population
            TextView titleGoal = (TextView) convertView.findViewById(R.id.goaltitle);
            titleGoal.setText(goal.title);

            TextView noGoal = (TextView) convertView.findViewById(R.id.goalno);
            noGoal.setText(goal.day + "/21");

            SeekBar daysGoal = (SeekBar) convertView.findViewById(R.id.goaldays);
            daysGoal.setMax(21);
            daysGoal.setProgress(goal.day);
            daysGoal.setEnabled(false);
            daysGoal.refreshDrawableState();


            return convertView;
        }
    }


    public class Goal {
        String title;
        int day;

        public Goal(String title, int day){
            this.title = title;
            this.day = day;
        }

    }

    @Override
    public void onClick(View v) {

    }
}
