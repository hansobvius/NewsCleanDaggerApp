package com.example.newsapp.ViewModel.mapper;

import com.example.domain.entity.ArticleEntity;
import com.example.newsapp.ViewModel.application.MainApplication;
import com.example.newsapp.model.Article;

import java.util.List;

public class MainAppMapper implements MapperImplementation<Article, ArticleEntity> {

    @Override
    public Article entityToModel(ArticleEntity entity) {
        return new Article(entity.getmId(), entity.getmName(), entity.getmAuthor(), entity.getmTitle(),
                entity.getmDescription(), entity.getmUrl(), entity.getmImage(), entity.getmDate(), entity.getmContent());
    }
}
