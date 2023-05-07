package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Fraza.class, version = 1, exportSchema = false)
public abstract class FrazaDatabase extends RoomDatabase {
    abstract FrazaDao frazaDao();

    private static volatile FrazaDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseWriteExecute = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static FrazaDatabase getDatabase(final Context context){
    if(INSTANCE == null) {
        synchronized (FrazaDatabase.class) {
            if (INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context.getApplicationContext(),FrazaDatabase.class, "baza-frazy").build();
            }
        }
    }
    return INSTANCE;
    }
}
