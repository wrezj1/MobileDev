package com.example.wz.ns;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.wz.ns.Database.AppDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @BindView(R.id.inp_from)
    public EditText from;

    @BindView(R.id.inp_to)
    public EditText to;

    private String dateTime = "";
    private Boolean departure = true;
    private static AppDatabase db;

    @BindView(R.id.btn_departure)
    Button b;

    @BindView(R.id.view_dateTime)
    TextView viewDateTime;

    private int year, month, day;
    private int finalYear, finalMonth, finalDay;


    private int hour, minutes;
    private int finalHour, finalMinutes;

    private Calendar c = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        db = AppDatabase.getInstance(getApplicationContext());
        b.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_history)
    public void openHistory() {
        if (db.userJourney().getAllUserJourney().size() != 0) {
            System.out.println(db.userJourney().getAllUserJourney().size());
            Intent i = new Intent(this, SavedJourneyActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Nothing to show", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.btn_find)
    public void findJourney() {

        makeRequest();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }


    @OnClick(R.id.btn_pickTime)
    public void pickTime() {
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, MainActivity.this,
                year, month, day);

        datePickerDialog.show();
    }

    @OnClick(R.id.btn_departure)
    public void setDeparture() {

        if (departure) {
            departure = false;
            b.setText("Arrival");
        } else {
            departure = true;
            b.setText("Departure");
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        finalYear = i;
        finalMonth = i1 + 1;
        finalDay = i2;

        hour = c.get(Calendar.HOUR_OF_DAY);

        minutes = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, MainActivity.this,
                hour, minutes, true);
        timePickerDialog.show();

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        finalHour = i;  System.out.println("HOUR"+i);
        finalMinutes = i1;
        b.setVisibility(View.VISIBLE);
        viewDateTime.setText(pad(finalHour) + ":" + pad(finalMinutes) +" " + finalDay+"-"+ finalMonth+"-" +finalYear);
    }

    private void makeRequest() {
        if (isNetworkConnected()) {
            String from = this.from.getText().toString();
            String to = this.to.getText().toString();

            //prepare dateTime format
            dateTime = finalYear + "-" + finalMonth + "-" + finalDay + "T" + pad(finalHour) + ":" + pad(finalMinutes)+ ":00";


            //chech if input is not empty & saving the search stations to the database
            if (!from.matches("") && !to.matches("")) {
                //check if both input is the same
                if (from.matches(to)) {
                    Toast.makeText(this, "Both stations are the same", Toast.LENGTH_LONG).show();
                }
                //prepare the intent & start new activity
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("from", from);
                intent.putExtra("to", to);
                intent.putExtra("dateTime", dateTime);
                intent.putExtra("departure", departure);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Fill in both locations", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Check internet connection", Toast.LENGTH_LONG).show();
        }
    }


    //method to add 0 to timePicker return value to format hh:mm
    private String pad(int value){

        if(value<10){
            return "0"+value;
        }
        return ""+value;
    }
}