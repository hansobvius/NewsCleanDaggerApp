package com.example.remote.factory;

import com.example.remote.Constants;
import com.example.remote.DataEndpoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceApi {

    private Retrofit retrofit;

    private static final String BASE_URL = "";

    public ServiceApi(){}

    public DataEndpoint getService(){
        String url =  Constants.BASE_URL;
        retrofit = new Retrofit
                .Builder()
                .baseUrl(url    )
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(DataEndpoint.class);
    }
}
