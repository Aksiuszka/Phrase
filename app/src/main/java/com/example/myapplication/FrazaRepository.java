package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FrazaRepository {
    private FrazaDao mFrazaDao;
    private LiveData<List<Fraza>> wszystkieFrazy;

    FrazaRepository(Application application){
        FrazaDatabase db = FrazaDatabase.getDatabase(application);
        mFrazaDao = db.frazaDao();
        wszystkieFrazy = mFrazaDao.selectFrazy();
    }

    LiveData<List<Fraza>> podajFrazy(){
        return wszystkieFrazy;
    }

    void insert(Fraza fraza){
        FrazaDatabase.databaseWriteExecute.execute(()->{
            mFrazaDao.insert(fraza);
        });
    }
}
