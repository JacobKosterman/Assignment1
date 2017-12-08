package com.example.jkosterman6222.assignment1;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class WelcomeToast {

    @PrimaryKey(autoGenerate = true)
    int id;
    public String name;
    public String comment;

    public WelcomeToast( String name, String comment) {
        this.name = name;
        this.comment = comment;

    }

}