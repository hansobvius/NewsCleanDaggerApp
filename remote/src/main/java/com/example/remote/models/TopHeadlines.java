package com.example.remote.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;

public class TopHeadlines {

    @SerializedName("articles")
    List<Articles> mArticles;

    public List<Articles> getmArticles() {
        return mArticles;
    }

    public void setmArticles(List<Articles> mArticles) {
        this.mArticles = mArticles;
    }
}
