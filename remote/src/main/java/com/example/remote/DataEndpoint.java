package com.example.remote;

import com.example.remote.models.Articles;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataEndpoint {

    @GET("{country}/{apiKey}")
    Call<List<Articles>> getArticles(
            @Path("country") String country,
            @Path("apiKey") String key);
}
