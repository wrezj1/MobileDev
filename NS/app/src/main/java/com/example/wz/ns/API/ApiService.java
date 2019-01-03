package com.example.wz.ns.API;

import com.example.wz.ns.model.MainTest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
        String BASE_URL = "https://ns-api.nl/";


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        @Headers("x-api-key:tB3ftiVRG94ynW9yPjaDC1fqCr0hwuaL3Jq5LoLQ")
        @GET("/reisinfo/api/v3/trips")
        Call<MainTest> getTrip(@Query("fromStation") String from, @Query("toStation") String to,
                               @Query("dateTime")String dateTime, @Query("departure") String departure);
}
