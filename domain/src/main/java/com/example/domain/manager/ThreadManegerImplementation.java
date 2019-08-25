package com.example.domain.manager;

import com.example.domain.entity.ArticleEntity;

import java.util.List;

public interface ThreadManegerImplementation {

    void setArticles(List<ArticleEntity> articleEntityList);

    List<ArticleEntity> getArticles(List<ArticleEntity> articleEntities);
}
