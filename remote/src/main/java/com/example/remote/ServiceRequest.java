package com.example.remote;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.cache.dao.article.Article;
import com.example.cache.manager.DatabaseManager;
import com.example.remote.factory.ServiceApi;
import com.example.remote.mapper.ProjectMapper;
import com.example.remote.models.TopHeadlines;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceRequest {

    private ServiceApi serviceApi;
    private Context mContext;
    private DatabaseManager databaseManager;
    private ProjectMapper projectMapper;

    public ServiceRequest(Context context){
        this.mContext = context;
        this.serviceApi = new ServiceApi();
        this.databaseManager = new DatabaseManager(mContext);
        this.projectMapper = new ProjectMapper();
    }

    public void getAllArticles(String country, String key){
        serviceApi
                .getService()
                .getAllArticles(country, key)
                .enqueue(new Callback<TopHeadlines>() {
                    @Override
                    public void onResponse(@NonNull Call<TopHeadlines> call, @NonNull Response<TopHeadlines> response) {
                        if(response.body() != null){
                            Log.i("retrofit", response.body().toString());
                            List<Article> articlesList = new ArrayList<>();
                            for(int i = 0; i < response.body().getmArticles().size(); i++){
                                Article article = new Article();
                                article = projectMapper.modelConverter(
                                                response.body().getmArticles().get(i));
                                articlesList.add(article);
                            }
                            databaseManager.insertArticles(articlesList, mContext);

                        }else{
                            Log.i("retrofit", "onResponse error " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<TopHeadlines> call, @NonNull Throwable t) {
                            Log.i("retrofit", "onFailure " + t.toString());
                    }
                });
    }
}
