package com.example.wz.ns;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wz.ns.API.ApiService;
import com.example.wz.ns.Database.AppDatabase;
import com.example.wz.ns.model.Destination;
import com.example.wz.ns.model.MainTest;
import com.example.wz.ns.model.Origin;
import com.example.wz.ns.model.Product;
import com.example.wz.ns.model.Trip;
import com.example.wz.ns.model.UserJourney;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends AppCompatActivity implements MainTestAdapter.MainTestClickListener {

    private String from;
    private String to;
    private ApiService service;
    private List<Origin> originList = new ArrayList<>();
    private List<Destination> destList = new ArrayList<>();
    private List<Trip> tripList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private MainTestAdapter mAdapter;
    private static AppDatabase db;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.view_originName)
    TextView originName;

    @BindView(R.id.view_destName)
    TextView destName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        service = ApiService.retrofit.create(ApiService.class);

        Intent intent = getIntent();

        from = intent.getStringExtra("from");
        to = intent.getStringExtra("to");

        setUpRecycleView();

        // getting actual data from user input
        try {
            requestData(from, to);
        } catch (Exception e) {
            Toast.makeText(this, "No connection with the api available", Toast.LENGTH_LONG).show();
        }
    }

    private void setUpRecycleView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainTestAdapter(tripList, originList, destList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    protected void requestData(final String from, final String to) {
        Call<MainTest> call = service.getTrip(from, to);
        call.enqueue(new Callback<MainTest>() {
            @Override
            public void onResponse(Call<MainTest> call, Response<MainTest> response) {
                MainTest ns = response.body();
                // checking if respone is empty
                if (ns != null) {

                    for (int i = 0; i < ns.getTrips().size(); i++) {
                        tripList.add(ns.getTrips().get(i));
                        originList.add(ns.getTrips().get(i).getLegs().get(0).getOrigin());
                        productList.add(ns.getTrips().get(i).getLegs().get(0).getProduct());
                        //number 1 is to translate the right position in a list
                        destList.add(ns.getTrips().get(i).getLegs().get(ns.getTrips().get(i).getLegs().size() - 1).getDestination());
                    }
                    originName.setText(originList.get(0).getName());
                    destName.setText(destList.get(0).getName());
                    mAdapter.notifyDataSetChanged();

                    //save the input from user because the stations are found
                    UserJourney u = new UserJourney(from, to);
                    db = AppDatabase.getInstance(getApplicationContext());
                    db.userJourney().insertUserJourney(u);
                } else {
                    //if response is empty send back to start screen
                    //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Geen station(s) gevonden", Toast.LENGTH_LONG).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<MainTest> call, Throwable t) {
                Log.e("FAILURE", t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void mainTestOnClick(int i) {
        //sending data to the ExtraResultFragment class
        Intent intent = new Intent(ResultActivity.this, ExtraResultFragment.class);
        intent.putExtra("Trip", tripList.get(i).getCrowdForecast());
        intent.putExtra("originSpoor", originList.get(i).getPlannedTrack());
        intent.putExtra("destSpoor", destList.get(i).getPlannedTrack());
        intent.putExtra("origin", originList.get(i).getName());
        intent.putExtra("dest", destList.get(i).getName());
        intent.putExtra("exitSite", destList.get(i).getExitSide());
        intent.putExtra("trainType", productList.get(i).getDisplayName());
        startActivity(intent);
    }
}
