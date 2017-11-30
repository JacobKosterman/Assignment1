package com.example.jkosterman6222.assignment1;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by vogella on 06.09.17.
 */
@Entity
public class User {

    @PrimaryKey
    public final int id;
    public String name;
    public int level;
    public long skillPoints;


    public User(int id, String name, long skillPoints) {
        this.id = id;
        this.name = name;
        this.skillPoints  = skillPoints;
        this.level = 0;
    }

}