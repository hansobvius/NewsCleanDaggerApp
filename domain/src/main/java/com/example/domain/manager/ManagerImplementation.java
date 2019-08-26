package com.example.domain.manager;

import com.example.cache.dao.article.Article;
import com.example.domain.entity.ArticleEntity;

import java.util.List;

public interface ManagerImplementation<M> {

    List<M> getArticles();

    void setArticles(List<M> articles);
}