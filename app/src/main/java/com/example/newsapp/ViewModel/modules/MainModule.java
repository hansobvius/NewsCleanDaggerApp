package com.example.newsapp.ViewModel.modules;

import com.example.cache.dao.article.Article;
import com.example.cache.manager.DatabaseManager;
import com.example.newsapp.ViewModel.application.MainApplication;
import com.example.newsapp.ViewModel.repository.MainRepository;
import com.example.newsapp.model.ArticleEntity;
import com.example.newsapp.model.mapper.ArticlesMapper;
import com.example.newsapp.view.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    DatabaseManager databaseManager;
    MainApplication mainApplication;
    ArticlesMapper articlesMapper;

    public MainModule(MainApplication mainApplication){
        this.mainApplication = mainApplication;
        this.articlesMapper = new ArticlesMapper();
        this.databaseManager = new DatabaseManager(this.mainApplication.getApplicationContext());
    }

    @Provides
    @Singleton
    List<ArticleEntity> providesArticles(){
        List<ArticleEntity> articleEntities = new ArrayList<>();
        List<Article> articles = new ArrayList<>(databaseManager.getArticles());
        for(Article article : articles){
            articleEntities.add(articlesMapper.modelToEntity(article));
        }
        return articleEntities;
    }

    @Provides
    @Singleton
    MainRepository providesMainRepository(List<ArticleEntity> articleEntities){
        return new MainRepository(articleEntities);
    }

    @Provides
    @Singleton
    MainApplication providesMainApplication(){
        return new MainApplication();
    }

    @Provides
    @Singleton
    MainAdapter providesMainAdapter(){
        return new MainAdapter(mainApplication.getApplicationContext());
    }
}
