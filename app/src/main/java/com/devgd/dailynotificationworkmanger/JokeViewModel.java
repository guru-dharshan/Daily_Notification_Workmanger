package com.devgd.dailynotificationworkmanger;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class JokeViewModel extends AndroidViewModel {
    LiveData<JokeEntity> jokeEntity;
    JokeRepo jokeRepo;
    public JokeViewModel(@NonNull Application application) {
        super(application);
        jokeRepo=new JokeRepo(application);
    }

}
