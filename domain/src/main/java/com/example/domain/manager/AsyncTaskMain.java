package com.example.domain.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import com.example.cache.dao.article.Article;
import com.example.cache.manager.DatabaseManager;
import com.example.domain.entity.ArticleEntity;
import com.example.domain.mapper.ProjectMapper;

import java.util.ArrayList;
import java.util.List;

public class AsyncTaskMain implements ManagerImplementation<Article> {

    private DatabaseManager databaseManager;
    private Context context;

    public AsyncTaskMain(Context context){
        this.context = context;
        this.databaseManager = new DatabaseManager(context);
    }

    @Override
    public List<Article> getArticles() {
        return databaseManager.getArticles();
    }

    @Override
    public void setArticles(List<Article> articles) {
        databaseManager.insertArticles(articles, context);
    }

    @SuppressLint("StaticFieldLeak")
    static class insertArticles extends AsyncTask<List<ArticleEntity>, Void, List<ArticleEntity>> {

        Context context;
        DatabaseManager databaseManager;
        ProjectMapper projectMapper = new ProjectMapper();

        insertArticles(DatabaseManager databaseManager, Context context){
            this.databaseManager = databaseManager;
            this.context = context;
        }

        @Override
        protected List<ArticleEntity> doInBackground(List<ArticleEntity>... lists) {
            List<ArticleEntity> listArticle = lists[0];
            List<Article> article = new ArrayList<>();
            for(ArticleEntity articleEntity : listArticle){
                article.add(projectMapper.entityToModel(articleEntity));
            }
            databaseManager.insertArticles(article, context);
            return null;
        }
    }
}
