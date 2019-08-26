package com.example.newsapp.ViewModel.modules;

import com.example.domain.DomainCore;
import com.example.domain.entity.ArticleEntity;
import com.example.newsapp.ViewModel.application.MainApplication;
import com.example.newsapp.ViewModel.mapper.MainAppMapper;
import com.example.newsapp.ViewModel.repository.MainRepository;
import com.example.newsapp.model.Article;
import com.example.newsapp.model.mapper.ArticlesMapper;
import com.example.newsapp.view.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainApplication mainApplication;
    private ArticlesMapper articlesMapper;
    private DomainCore domainCore;
    private MainAppMapper mainAppMapper;

    public MainModule(MainApplication mainApplication){
        this.mainApplication = mainApplication;
        this.articlesMapper = new ArticlesMapper();
        this.domainCore = new DomainCore(mainApplication.getApplicationContext());
        this.mainAppMapper = new MainAppMapper();
    }

    @Provides
    @Singleton
    List<Article> providesArticles(){
        List<Article> articles = new ArrayList<>();
        List<ArticleEntity> articleEntities = new ArrayList<>(domainCore.getArticleList());
        for(ArticleEntity articleEntity : articleEntities){
            articles.add(mainAppMapper.entityToModel(articleEntity));
        }
        return articles;
    }

    @Provides
    @Singleton
    MainRepository providesMainRepository(List<Article> articleEntities){
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
