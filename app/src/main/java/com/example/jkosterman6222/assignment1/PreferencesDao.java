package com.example.jkosterman6222.assignment1;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface PreferencesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPreferences(Preferences preferences);

    @Query("SELECT * FROM preferences WHERE userId=:userId")
    List<Preferences> findPreferencesForUser(int userId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatePreferences(Preferences preferences);

    @Query("delete from preferences where id = :id")
    void delete(long id);

}