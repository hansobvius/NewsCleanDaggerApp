package com.example.newsapp.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.newsapp.R;
import com.example.newsapp.ViewModel.MainViewModel;
import com.example.newsapp.ViewModel.application.MainApplication;
import com.example.newsapp.databinding.ActivityMainBinding;
import com.example.newsapp.model.ArticleEntity;
import com.example.newsapp.view.adapter.MainAdapter;
import com.example.remote.Constants;
import com.example.remote.ServiceRequest;
import com.facebook.stetho.Stetho;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    ActivityMainBinding mainBinding;
    ServiceRequest serviceRequest;

    @Inject
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.mainRecycler.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart(){
        super.onStart();
        serviceRequest = new ServiceRequest(this);
        serviceRequest.getAllArticles(Constants.DEFAULT_COUNTRY, Constants.KEY);

        MainApplication.getMainApplication().getMainComponent().inject(this);
        final MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        observeViewModel(viewModel);
    }

    public void observeViewModel(MainViewModel mainViewModel){
        mainViewModel.getArticleObservable().observe(this, new Observer<List<ArticleEntity>>() {
            @Override
            public void onChanged(List<ArticleEntity> articleEntities) {
                if(!articleEntities.isEmpty()){
                    Log.i("newsApp", "articles not empty " + articleEntities.size());
                }else{
                    Log.i("newsApp", "articles are empty");
                }
                mainAdapter.addArticles(articleEntities);
                mainBinding.mainRecycler.setAdapter(mainAdapter);
            }
        });
    }
}
