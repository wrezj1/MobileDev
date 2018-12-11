package com.example.wz.numbertrivia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wz.numbertrivia.api.ApiService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Trivia> triviaCards = new ArrayList<>();
    private TriviaCardAdapter mAdapter;
    ApiService.TriviaApiService service;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupRecyclerView();
        service = ApiService.TriviaApiService.retrofit.create(ApiService.TriviaApiService.class);
    }


    @OnClick(R.id.btn_add_trivia)
    public void showTrivia() {
        requestData();


    }

    private void setupRecyclerView() {

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TriviaCardAdapter(triviaCards);
        recyclerView.setAdapter(mAdapter);
    }

    private void addToTriviaList(Trivia trivia) {
        triviaCards.add(trivia);
        mAdapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(triviaCards.size() - 1);
    }

    private void requestData() {
        Call<Trivia> call = service.getRandomTrivia();
        call.enqueue(new Callback<Trivia>() {
            @Override
            public void onResponse(Call<Trivia> call, Response<Trivia> response) {
                Trivia trivia = response.body();
                addToTriviaList(trivia);

            }

            @Override
            public void onFailure(Call<Trivia> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something went wrong, try again later or restart the app", '3');
            }
        });

    }

}



