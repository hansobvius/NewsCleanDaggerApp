package com.example.newsapp.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.newsapp.R;
import com.example.newsapp.databinding.ActivityMainBinding;
import com.example.remote.Constants;
import com.example.remote.ServiceRequest;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    private ServiceRequest serviceRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        serviceRequest = new ServiceRequest(this);
        serviceRequest.getAllArticles(Constants.DEFAULT_COUNTRY, Constants.KEY);
    }
}
