package com.devgd.dailynotificationworkmanger;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class JokeRepo{
    static JokeDao jokeDao;
    JokeRepo(Application application){
        JokeRoom jokeRoom=JokeRoom.getInstance(application);
        jokeDao=jokeRoom.jokeDao();
    }




}
