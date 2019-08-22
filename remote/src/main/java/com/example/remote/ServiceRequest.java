package com.example.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.remote.factory.ServiceApi;
import com.example.remote.models.Articles;
import com.example.remote.models.TopHeadlines;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceRequest {

    private ServiceApi serviceApi = new ServiceApi();

    public void getAllArticles(String country, String key){
        serviceApi
                .getService()
                .getAllArticles(country, key)
                .enqueue(new Callback<TopHeadlines>() {
                    @Override
                    public void onResponse(Call<TopHeadlines> call, Response<TopHeadlines> response) {
                        if(response.body() != null){
                            Log.i("retrofit", response.body().toString());
                        }else{
                            Log.i("retrofit", "onResponse error " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<TopHeadlines> call, Throwable t) {
                            Log.i("retrofit", "onFailure " + t.toString());
                    }
                });

    }
}
