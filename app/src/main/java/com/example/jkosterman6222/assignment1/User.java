package com.example.jkosterman6222.assignment1;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by vogella on 06.09.17.
 */
@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public final int id;
    public String name;
    public String password;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = "test";
    }

}