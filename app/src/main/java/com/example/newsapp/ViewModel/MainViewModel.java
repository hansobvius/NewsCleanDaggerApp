package com.example.newsapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.newsapp.ViewModel.application.MainApplication;
import com.example.newsapp.ViewModel.repository.MainRepository;
import com.example.newsapp.model.ArticleEntity;
import com.example.newsapp.view.activities.MainActivity;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends AndroidViewModel {

    public final LiveData<List<ArticleEntity>> listLiveData;

    @Inject
    MainRepository mainRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        MainApplication.getMainApplication().getMainComponent().inject(this);
        listLiveData = mainRepository.getArticlesList();
    }

    public LiveData<List<ArticleEntity>> getArticleObservable(){
        return listLiveData;
    }
}
