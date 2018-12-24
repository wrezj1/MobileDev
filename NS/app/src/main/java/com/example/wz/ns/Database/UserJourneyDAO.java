package com.example.wz.ns.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;
import android.arch.persistence.room.Query;


import com.example.wz.ns.model.UserJourney;

import java.util.List;

@Dao
public interface UserJourneyDAO {

    @Query("SELECT * FROM userJourney")
    public List<UserJourney> getAllUserJourney();

    @Insert
    public void insertUserJourney(UserJourney userJourney);

    @Delete
    public void deleteUserJourney(UserJourney userJourney);

    @Update
    public void updateUserJourney(UserJourney userJourney);

}