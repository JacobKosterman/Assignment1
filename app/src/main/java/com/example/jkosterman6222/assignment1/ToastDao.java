package com.example.jkosterman6222.assignment1;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface ToastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addToast(User user);

   /* @Query("select * from user")
    public List<User> getAllToast();*/

    @Query("select * from toast where id = :toastId")
    public List<User> getToast(long userId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateToast(User user);

    @Query("delete from toast")
    void removeAllToasts();
}