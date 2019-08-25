package com.example.newsapp.ViewModel.application;

import android.app.Application;

import com.example.newsapp.ViewModel.components.DaggerMainComponent;
import com.example.newsapp.ViewModel.components.MainComponent;
import com.example.newsapp.ViewModel.modules.MainModule;

public class MainApplication extends Application {

    private static MainApplication mainApplication;

    MainComponent mainComponent;

    public static MainApplication getMainApplication(){
        return mainApplication;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        mainApplication = this;
        initializeComponent();
        mainComponent.inject(this);
    }

    private void initializeComponent(){
        mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build();
    }

    public MainComponent getMainComponent(){
        return mainComponent;
    }
}
