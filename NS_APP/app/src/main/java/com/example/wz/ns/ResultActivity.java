package com.example.wz.ns;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wz.ns.API.ApiService;
import com.example.wz.ns.Database.AppDatabase;
import com.example.wz.ns.model.CustomTrip;
import com.example.wz.ns.model.Leg;
import com.example.wz.ns.model.MainTest;
import com.example.wz.ns.model.UserJourney;
import com.google.gson.Gson;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends AppCompatActivity implements MainTestAdapter.MainTestClickListener {

    private String from;
    private String to;
    private String journeyTime;
    private String journeyDate;
    private Boolean departure;
    private String dateTime;
    private ApiService service;
    private RecyclerView mRecyclerView;
    private MainTestAdapter mAdapter;
    private static AppDatabase db;

    MainTest ns = null;
    CustomTrip ct;


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.view_originName)
    TextView originName;

    @BindView(R.id.view_destName)
    TextView destName;

    @Nullable
    @BindView(R.id.view_waitText )
    TextView waitText;

    @BindView(R.id.view_result_date)
    TextView date;

    @BindView(R.id.view_result_time)
    TextView time;

    @BindView(R.id.view_today)
    TextView today;


    private List<CustomTrip> customTrips = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        //starting api service
        service = ApiService.retrofit.create(ApiService.class);

        //getting intent from mainActivity
        Intent intent = getIntent();
        from = intent.getStringExtra("from");
        to = intent.getStringExtra("to");
        journeyTime = intent.getStringExtra("journeyTime");
        journeyDate = intent.getStringExtra("journeyDate");
        dateTime = intent.getStringExtra("dateTime");
        departure = intent.getBooleanExtra("departure",true);


        // getting actual data from user input and saving to db
        try {
            requestData(from, to);
            //save the input from user because the stations are found
            UserJourney u = new UserJourney(from, to);
            db = AppDatabase.getInstance(getApplicationContext());
            db.userJourney().insertUserJourney(u);
        } catch (Exception e) {
            Toast.makeText(this, "No connection with the api available", Toast.LENGTH_LONG).show();
        }

        setUpRecycleView();
    }

    private void setUpRecycleView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainTestAdapter(customTrips, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    protected void requestData(final String from, final String to) {
        Call<MainTest> call = service.getTrip(from, to, dateTime, departure);
        call.enqueue(new Callback<MainTest>() {
            @Override
            public void onResponse(Call<MainTest> call, Response<MainTest> response) {
                //saving the maintest object
                ns = response.body();
                // checking if respone is empty
                if (ns != null) {
                    configure();
                    waitText.setVisibility(TextView.INVISIBLE);

                } else {
                    //if response is empty send back to start screen
                    Toast.makeText(getApplicationContext(), "No station(s) found", Toast.LENGTH_LONG).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<MainTest> call, Throwable t) {
                Log.e("FAILURE", t.getLocalizedMessage());
                Toast.makeText(getApplicationContext(), "Timedout.. try again", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    //create object from
    private void configure() {
        int tripSize = ns.getTrips().size();
        int legSize;

        //loop through de "trips" and extract the needed information
        for (int i = 0; i < tripSize; i++) {
            legSize = ns.getTrips().get(i).getLegs().size();
            // loop through the legs and extract data, -1 is because lists start at position 0
            ct = new CustomTrip(ns.getTrips().get(0).getLegs().get(0).getOrigin().getName(),
                    ns.getTrips().get(i).getLegs().get(0).getOrigin().getPlannedDateTime(),
                    ns.getTrips().get(i).getLegs().get(legSize - 1).getDestination().getName(),
                    ns.getTrips().get(i).getLegs().get(legSize - 1).getDestination().getPlannedDateTime(),
                    ns.getTrips().get(i).getPlannedDurationInMinutes().toString(),
                    ns.getTrips().get(i).getCrowdForecast(), ns.getTrips().get(i).getStatus());
            //saving nested list of transfers
            for (int y = 0; y < legSize; y++) {
                ct.setCustomLeg(ns.getTrips().get(i).getLegs());
            }

            customTrips.add(ct);
        }
        originName.setText(customTrips.get(0).getOrigin());
        destName.setText(customTrips.get(0).getDest());
        mAdapter.notifyDataSetChanged();

       checkTimeDateOnSet();
    }

    private void checkTimeDateOnSet(){
        //if date is not set
        if(dateTime != null && !dateTime.matches("0-0-0T00:00:00")){
            date.setText(journeyDate);
            time.setText(journeyTime);
        }else{
            today.setText("Today");
        }
    }


    @Override
    public void mainTestOnClick(int i) {
        int tripSize;

        Intent intent = new Intent(ResultActivity.this, ExtraResultFragment.class);
        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) customTrips.get(i).getCustomLeg());
        tripSize = customTrips.size();
        intent.putExtra("bundle", args);
        intent.putExtra("tripSize", tripSize);

        if(null != ns.getTrips().get(i).getProductFare()){
        intent.putExtra("crowd", ns.getTrips().get(i).getCrowdForecast());
        intent.putExtra("price", ns.getTrips().get(i).getProductFare().getPriceInCents());
        }
        startActivity(intent);

    }
}
