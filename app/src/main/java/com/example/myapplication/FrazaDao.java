package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FrazaDao {
    @Query("SELECT * FROM tabela_frazy ORDER BY fraza ASC")
    LiveData<List<Fraza>> selectFrazy();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Fraza fraza);

    @Query("DELETE FROM tabela_frazy")
    void deleteAll();
}
