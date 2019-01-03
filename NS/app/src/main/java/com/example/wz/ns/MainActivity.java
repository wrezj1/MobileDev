package com.example.wz.ns;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.Toast;

import com.example.wz.ns.Database.AppDatabase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.inp_from)
    public EditText from;

    @BindView(R.id.inp_to)
    public EditText to;

    private String dateTime = "2018-12-25T22:00:00";
    private String departure = "true";
    private static AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        db = AppDatabase.getInstance(getApplicationContext());
    }

    @OnClick(R.id.btn_history)
    public void openHistory() {
        if (db.userJourney().getAllUserJourney().size() != 0) {
            System.out.println(db.userJourney().getAllUserJourney().size());
            Intent i = new Intent(this, SavedJourneyActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Nothing to show", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.btn_find)
    public void findJourney() {
        //check for internet connection
        if (isNetworkConnected()) {
            String from = this.from.getText().toString();
            String to = this.to.getText().toString();
            //chech if input is not empty & saving the search stations to the database
            if (!from.matches("") && !to.matches("")) {
                //check if both input is the same
                if (from.matches(to)) {
                    Toast.makeText(this, "Both statoins are the same", Toast.LENGTH_LONG).show();
                }
                //prepare the intent & start new activity
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("from", from);
                intent.putExtra("to", to);
                intent.putExtra("dateTime",dateTime);
                intent.putExtra("departure",departure);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Fill in both locations", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Check internet connection", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }


}