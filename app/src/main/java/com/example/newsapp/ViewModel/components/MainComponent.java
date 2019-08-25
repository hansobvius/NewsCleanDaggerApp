package com.example.newsapp.ViewModel.components;

import com.example.newsapp.ViewModel.MainViewModel;
import com.example.newsapp.ViewModel.application.MainApplication;
import com.example.newsapp.ViewModel.modules.MainModule;
import com.example.newsapp.view.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainApplication mainApplication);

    void inject(MainViewModel mainViewModel);

    void inject(MainActivity mainActivity);
}
