package com.example.feroli.days;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.lylc.widget.circularprogressbar.CircularProgressBar;


public class MainActivity extends AppCompatActivity{

    String addGoalInput;
    String mGoal = "empty";
    TextView mTextQuote;

    private CircularProgressBar mCProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View goalInfo = findViewById(R.id.goalinfo);

        mCProgress = (CircularProgressBar) findViewById(R.id.circularprogressbar1);
        mCProgress.setProgress(0);
        mCProgress.setTitle("Your goal");
        mCProgress.setSubTitle("");

        goalInfo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Are you sure about this?");
                builder.setMessage("Would you like to delete your goal?");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mCProgress.setTitle("Your goal");
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


        final FloatingActionsMenu mainbutton = (FloatingActionsMenu) findViewById(R.id.mainbutton);

        final FloatingActionButton smoking = (FloatingActionButton) findViewById(R.id.smoking);
        smoking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCProgress.setTitle("No smoking");
                mGoal = "smoking";
                mCProgress.setProgress(0);
                mainbutton.collapse();

            }
        });

        FloatingActionButton nosleep = (FloatingActionButton) findViewById(R.id.nosleep);
        nosleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCProgress.setTitle("Early Bird");
                mGoal = "early";
                mCProgress.setProgress(0);
                mainbutton.collapse();

            }
        });

        mTextQuote = (TextView) findViewById(R.id.quote);

        FloatingActionButton ghost = (FloatingActionButton) findViewById(R.id.ghost);
        ghost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCProgress.getProgress() + 5 != 100) {
                    mCProgress.setProgress(mCProgress.getProgress() + 5);
                    if(mGoal.equals("smoking")){
                        mTextQuote.setText(SmokingText(mCProgress.getProgress() + 5));
                    }
                }else{

                    mTextQuote.setText("");
                    mCProgress.setProgress(0);
                    Toast.makeText(MainActivity.this, "Congratulations!", Toast.LENGTH_SHORT).show();
                    NotificationCompat.Builder mBuilder =
                            new NotificationCompat.Builder(MainActivity.this)
                                    .setSmallIcon(R.drawable.trophy)
                                    .setContentTitle("Congrats!")
                                    .setContentText("Your trophy has been stored in your collection!");
                    int mNotificationId = 001;
                    NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    mNotifyMgr.notify(mNotificationId, mBuilder.build());
                }
            }
        });




    }

    public String SmokingText(int p){
        String text = "empty";
        switch (p){
            case 5:
                text = "Risks of heart attack are reduced.";
                break;
            case 10:
                text = "Nicotine has left your bloodstream.";
                break;
            case 15:
                text = "Your sense of smell and taste are returning to normal.";
                break;
            case 20:
                text = "Damaged nerve endings have started to regrow.";
                break;
            case 25:
                text = "Risks of heart attack are reduced.";
                break;
            case 30:
                text = "Nicotine has left your bloodstream.";
                break;
            case 35:
                text = "Your sense of smell and taste are returning to normal.";
                break;
            case 40:
                text = "Damaged nerve endings have started to regrow.";
                break;
            case 45:
                text = "Risks of heart attack are reduced.";
                break;
            case 50:
                text = "Nicotine has left your bloodstream.";
                break;
            case 55:
                text = "Damaged nerve endings have started to regrow.";
                break;
            case 60:
                text = "Risks of heart attack are reduced.";
            case 65:
                text = "Your sense of smell and taste are returning to normal.";
                break;
            case 70:
                text = "Damaged nerve endings have started to regrow.";
                break;
            case 75:
                text = "Risks of heart attack are reduced.";
                break;
            case 80:
                text = "Nicotine has left your bloodstream.";
                break;
            case 85:
                text = "Your sense of smell and taste are returning to normal.";
                break;
            case 90:
                text = "Damaged nerve endings have started to regrow.";
                break;
            case 95:
                text = "Risks of heart attack are reduced.";
                break;
            case 100:
                text = "Nicotine has left your bloodstream.";
                break;

        }
        return text;
    }


}
