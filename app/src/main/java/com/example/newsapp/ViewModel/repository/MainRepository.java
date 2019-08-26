package com.example.newsapp.ViewModel.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newsapp.model.Article;

import java.util.List;

public class MainRepository {

    private List<Article> articleEntities;

    public MainRepository(List<Article> articleEntities){
        this.articleEntities = articleEntities;
    }

    public LiveData<List<Article>> getArticlesList(){
        final MutableLiveData<List<Article>> data = new MutableLiveData<>();
        data.setValue(articleEntities);
        return data;
    }
}
