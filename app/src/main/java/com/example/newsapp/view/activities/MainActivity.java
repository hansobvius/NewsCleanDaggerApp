package com.example.newsapp.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.newsapp.R;
import com.example.remote.Constants;
import com.example.remote.ServiceRequest;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    private ServiceRequest serviceRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);

    }

    @Override
    protected void onStart(){
        super.onStart();
        serviceRequest = new ServiceRequest(this);
        serviceRequest.getAllArticles(Constants.DEFAULT_COUNTRY, Constants.KEY);
    }
}
