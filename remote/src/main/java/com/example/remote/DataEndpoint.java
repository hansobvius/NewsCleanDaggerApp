package com.example.remote;

import com.example.remote.models.Articles;
import com.example.remote.models.TopHeadlines;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataEndpoint {

    @GET("top-headlines")
    Call<TopHeadlines> getAllArticles(
            @Query("country") String country,
            @Query("apiKey") String key);
}
