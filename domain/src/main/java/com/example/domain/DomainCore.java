package com.example.domain;

import android.content.Context;
import android.util.Log;

import com.example.domain.entity.ArticleEntity;
import com.example.domain.manager.AsyncTaskMain;
import com.example.domain.manager.ThreadManegerImplementation;
import com.example.remote.Constants;
import com.example.remote.ServiceRequest;

import java.util.List;

public class DomainCore implements ThreadManegerImplementation {

    AsyncTaskMain asyncTaskMain;
    ServiceRequest serviceRequest;
    Context context;

    public DomainCore(Context context){
        serviceRequest = new ServiceRequest(context);
        serviceRequest.getAllArticles(Constants.DEFAULT_COUNTRY, Constants.KEY);
    }

    public void initDatase(){
        asyncTaskMain = new AsyncTaskMain(context);
    }



    public List<ArticleEntity> getArticlesList(List<ArticleEntity> articleEntities){
        if(!articleEntities.isEmpty()){
            Log.i("newsApp", "domain list not null");
        }else{
            Log.i("newsApp", "domain list are null");
        }
        return articleEntities;
    }

    @Override
    public void setArticles(List<ArticleEntity> articleEntityList) {

    }

    @Override
    public List<ArticleEntity> getArticles(List<ArticleEntity> articleEntities) {
        return getArticlesList(articleEntities);
    }
}
