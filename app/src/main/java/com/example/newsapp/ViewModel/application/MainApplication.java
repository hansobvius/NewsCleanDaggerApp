package com.example.newsapp.ViewModel.application;

import android.app.Application;

public class MainApplication extends Application {

    private static MainApplication mainApplication;

    public static MainApplication getMainApplication(){
        return mainApplication;
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }

    private void initializeComponent(){

    }
}
