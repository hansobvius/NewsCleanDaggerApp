package com.example.domain.manager;

import android.content.Context;
import android.os.AsyncTask;

import com.example.cache.dao.article.Article;
import com.example.cache.manager.DatabaseManager;
import com.example.domain.entity.ArticleEntity;
import com.example.domain.mapper.ProjectMapper;

import java.util.ArrayList;
import java.util.List;

public class AsyncTaskMain implements ThreadManegerImplementation{

    private DatabaseManager databaseManager;
    private Context context;
    private ThreadManegerImplementation threadManegerImplementation;

    public AsyncTaskMain(Context context){
        this.context = context;
        databaseManager = new DatabaseManager(context);
        AsyncArticle asyncArticle = (AsyncArticle) new AsyncArticle(context, databaseManager, threadManegerImplementation);
        asyncArticle.execute();
    }

    @Override
    public void setArticles(List<ArticleEntity> articleEntityList) {

    }

    @Override
    public List<ArticleEntity> getArticles(List<ArticleEntity> articleEntities) {
        return articleEntities;
    }

    static class AsyncArticle extends AsyncTask<Void, Void, List<ArticleEntity>> {

        Context context;
        DatabaseManager databaseManager;
        List<ArticleEntity> articleEntities = new ArrayList<>();
        ProjectMapper projectMapper = new ProjectMapper();
        ThreadManegerImplementation threadManegerImplementation;

        AsyncArticle(Context context, DatabaseManager databaseManager, ThreadManegerImplementation threadManegerImplementation){
            this.context = context;
            this.databaseManager = databaseManager;
            this.threadManegerImplementation = threadManegerImplementation;
        }

        @Override
        protected List<ArticleEntity> doInBackground(Void... voids) {
            List<Article> articles = new ArrayList<>();
            articles.addAll(databaseManager.getArticles());
            for(Article article : articles){
                articleEntities.add(projectMapper.modelToEntity(article));
            }
            return articleEntities;
        }

        @Override
        protected void onPostExecute(List<ArticleEntity> articleEntities) {
            super.onPostExecute(articleEntities);
            threadManegerImplementation.setArticles(articleEntities);
        }
    }
}
