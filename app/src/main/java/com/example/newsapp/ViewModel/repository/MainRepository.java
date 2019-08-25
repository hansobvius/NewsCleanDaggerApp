package com.example.newsapp.ViewModel.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newsapp.model.ArticleEntity;

import java.util.List;

public class MainRepository {

    private List<ArticleEntity> articleEntities;

    public MainRepository(List<ArticleEntity> articleEntities){
        this.articleEntities = articleEntities;
    }

    public LiveData<List<ArticleEntity>> getArticlesList(){
        final MutableLiveData<List<ArticleEntity>> data = new MutableLiveData<>();
        data.setValue(articleEntities);
        return data;
    }
}
