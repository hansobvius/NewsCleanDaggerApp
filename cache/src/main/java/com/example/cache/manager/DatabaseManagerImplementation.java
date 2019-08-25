package com.example.cache.manager;

import android.content.Context;

import com.example.cache.dao.article.Article;
import com.example.cache.database.NewsDatabase;

import java.util.List;

public interface DatabaseManagerImplementation {

    void insertArticles(List<Article> articleList, Context context);

    List<Article> getArticles();
}
