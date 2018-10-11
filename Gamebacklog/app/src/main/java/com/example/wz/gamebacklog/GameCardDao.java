package com.example.wz.gamebacklog;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface GameCardDao {

    @Query("SELECT * FROM gameCard")
    public List<GameCard> getAllGameCards();

    @Insert
    public void insertGameCard(GameCard gameCard);

    @Delete
    public void deleteGameCard(GameCard gameCard);

    @Update
    public void updateGameCard(GameCard gameCard);


}

