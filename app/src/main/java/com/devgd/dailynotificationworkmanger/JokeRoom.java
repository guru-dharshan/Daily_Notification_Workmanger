package com.devgd.dailynotificationworkmanger;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = JokeEntity.class,version = 1)
public abstract class JokeRoom extends RoomDatabase {
    private static JokeRoom instance;
    public abstract JokeDao jokeDao();

    public static synchronized JokeRoom getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),JokeRoom.class,"eventRoom")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomcallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomcallback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new AddAsync(instance).execute();
        }
    };

    private static class AddAsync extends AsyncTask<Void,Void,Void> {
        JokeDao jokeDao;
        public AddAsync(JokeRoom db)
        {
            jokeDao=db.jokeDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {

            jokeDao.insert(new JokeEntity("All programmers are playwrights, and all computers are lousy actors."));
            jokeDao.insert(new JokeEntity("Have you heard about the new Cray super computer?  It’s so fast, it executes an infinite loop in 6 seconds."));
            jokeDao.insert(new JokeEntity("The generation of random numbers is too important to be left to chance."));
            jokeDao.insert(new JokeEntity("“I just saw my life flash before my eyes and all I could see was a close tag…"));
            jokeDao.insert(new JokeEntity("The computer is mightier than the pen, the sword, and usually, the programmer."));
            jokeDao.insert(new JokeEntity("Debugging: Removing the needles from the haystack."));
            jokeDao.insert(new JokeEntity("How many programmers does it take to change a light bulb?\n" +
                    "None – It’s a hardware problem"));
            jokeDao.insert(new JokeEntity("Follow dev__gd not a JOKE!"));
            return null;
        }
    }
}
