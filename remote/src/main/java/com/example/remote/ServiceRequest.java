package com.example.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.remote.factory.ServiceApi;
import com.example.remote.models.Articles;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceRequest {

    private ServiceApi serviceApi;

    public void getArticles(String country, String key){
        serviceApi
                .getService()
                .getArticles(country, key)
                .enqueue(new Callback<List<Articles>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Articles>> call, @NonNull Response<List<Articles>> response) {
                        if(response.body() != null){
                            Log.i("retrofit", response.body().toString());
                        }else{
                            Log.i("retrofit", "body are null " + response.code());
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Articles>> call, @NonNull Throwable t) {
                        Log.i("retrofit", t.toString());
                    }
                });
    }
}
