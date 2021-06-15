package com.devgd.dailynotificationworkmanger;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.io.DataInput;

import static com.devgd.dailynotificationworkmanger.Notification_Channel.Notification_ID;


public class workmanager extends Worker {
    Context context;
    String joke;
    JokeRoom jokeRoom;
    JokeDao jokeDao;
    public workmanager(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context=context;
        jokeRoom=JokeRoom.getInstance(context);
        jokeDao=jokeRoom.jokeDao();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public Result doWork() {

        JokeEntity jokeEntity = jokeDao.getRandom();
        joke=jokeEntity.getJoke();

        Notification notification=new Notification.Builder(getApplicationContext(),Notification_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Joke of the Day!")
                .setContentText(joke)

                .build()
                ;

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(1,notification);


        return Result.success();
    }
}
