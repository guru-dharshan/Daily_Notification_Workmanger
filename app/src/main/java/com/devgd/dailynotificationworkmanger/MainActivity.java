package com.devgd.dailynotificationworkmanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    String joke;
    JokeViewModel jokeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //view model and repository classes are already there!

    }

    public void start(View view) {
        PeriodicWorkRequest periodicWorkRequest=new PeriodicWorkRequest.Builder(workmanager.class,1,TimeUnit.DAYS)
                .build();
        WorkManager.getInstance().enqueue(periodicWorkRequest);
    }

    public void stop(View view){
    WorkManager.getInstance().cancelAllWork();
    }
}