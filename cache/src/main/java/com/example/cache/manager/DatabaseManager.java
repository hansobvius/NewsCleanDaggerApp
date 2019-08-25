package com.example.cache.manager;

import android.content.Context;

import com.example.cache.dao.article.Article;
import com.example.cache.dao.article.dao.ArticleDao;
import com.example.cache.database.NewsDatabase;

import java.util.List;

public class DatabaseManager implements DatabaseManagerImplementation {

    private ArticleDao articleDao;
    private Context context;

    public DatabaseManager(Context context){
        this.context = context;
        NewsDatabase newsDatabase = NewsDatabase.getNewsDatabase(context);
        articleDao = newsDatabase.articleDao();
    }

    @Override
    public void insertArticles(List<Article> articleList, Context context) {
        articleDao.insertArticle(articleList);
    }

    @Override
    public List<Article> getArticles() {
        return articleDao.getAllArticles();
    }
}
