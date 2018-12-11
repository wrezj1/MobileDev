package com.example.wz.numbertrivia.api;

import android.util.Log;

import com.example.wz.numbertrivia.Trivia;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class ApiService {
    public interface TriviaApiService {

        String BASE_URL = "http://numbersapi.com/";


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        @GET("/random?json&max9999")
        Call<Trivia> getRandomTrivia();

    }




}
