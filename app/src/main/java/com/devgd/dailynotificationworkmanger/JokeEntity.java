package com.devgd.dailynotificationworkmanger;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class JokeEntity {
    @PrimaryKey(autoGenerate = true)
    int id;

    String joke;

    public JokeEntity(String joke) {
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
