package com.example.domain;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.cache.dao.article.Article;
import com.example.cache.manager.DatabaseManager;
import com.example.domain.entity.ArticleEntity;
import com.example.domain.manager.AsyncTaskMain;
import com.example.domain.manager.ManagerImplementation;
import com.example.domain.mapper.ProjectMapper;
import com.example.remote.Constants;
import com.example.remote.ServiceRequest;

import java.util.ArrayList;
import java.util.List;

public class DomainCore{

    private AsyncTaskMain asyncTaskMain;
    private ServiceRequest serviceRequest;
    private DatabaseManager databaseManager;
    private Context mContext;
    private ProjectMapper projectMapper;


    public DomainCore(Context context){;
        this.mContext = context;
        this.projectMapper = new ProjectMapper();
        this.databaseManager = new DatabaseManager(mContext);
        initDatase();
    }

    private void initDatase(){
        this.serviceRequest = new ServiceRequest(mContext);
        this.serviceRequest.getAllArticles(Constants.DEFAULT_COUNTRY, Constants.KEY);
        asyncTaskMain = new AsyncTaskMain(mContext);
    }

    public List<ArticleEntity> getArticleList(){
        List<ArticleEntity> articleEntities = new ArrayList<>();
        List<Article> articles = new ArrayList<>(asyncTaskMain.getArticles());
        for(Article article : articles){
            articleEntities.add(projectMapper.modelToEntity(article));
        }
        return articleEntities;
    }

    public void insertArticleList(List<ArticleEntity> articleEntities){
        List<Article> article = new ArrayList<>();
        for(ArticleEntity articleEntity : articleEntities){
            article.add(projectMapper.entityToModel(articleEntity));
        }
        asyncTaskMain.setArticles(article);
    }
}
