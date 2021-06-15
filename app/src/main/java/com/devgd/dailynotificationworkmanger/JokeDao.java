package com.devgd.dailynotificationworkmanger;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface JokeDao {
    @Insert
    void insert(JokeEntity joke);

    @Query("SELECT * FROM JokeEntity ORDER BY RANDOM() LIMIT 1")
    JokeEntity getRandom();

}
