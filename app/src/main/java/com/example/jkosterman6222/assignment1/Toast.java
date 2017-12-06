package com.example.jkosterman6222.assignment1;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Toast {

    @PrimaryKey(autoGenerate = true)
    public final int id;
    public String name;
    public String comment;

    public Toast(int id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;

    }

}