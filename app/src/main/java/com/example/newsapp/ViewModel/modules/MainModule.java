package com.example.newsapp.ViewModel.modules;

import com.example.newsapp.ViewModel.application.MainApplication;

import dagger.Module;

@Module
public class MainModule {

    MainApplication mainApplication;

    public MainModule(MainApplication mainApplication){
        this.mainApplication = mainApplication;

    }
}
