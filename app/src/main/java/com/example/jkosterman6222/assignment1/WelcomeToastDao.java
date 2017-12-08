package com.example.jkosterman6222.assignment1;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface WelcomeToastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addWelcomeToast(WelcomeToast welcomeToast);

   @Query("select * from welcomeToast")
    public List<WelcomeToast> getAllWelcomeToast();

    @Query("select * from welcomeToast where id = :userId")
    public List<WelcomeToast> getWelcomeToast(long userId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateWelcomeToast(WelcomeToast welcomeToast);

    @Query("delete from welcomeToast")
    void removeAllWelcomeToasts();
}