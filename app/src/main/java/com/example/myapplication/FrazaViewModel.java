package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FrazaViewModel extends AndroidViewModel {

    private FrazaRepository frazaRepository;
    private LiveData<List<Fraza>> vmWszystkieFrazy;

    public FrazaViewModel(@NonNull Application application){
        super(application);

        frazaRepository = new FrazaRepository(application);
        vmWszystkieFrazy = frazaRepository.podajFrazy();


    }
    LiveData<List<Fraza>> podajFrazy(){
return vmWszystkieFrazy;
    }

    public void insert(Fraza fraza){
        frazaRepository.insert(fraza);
    }
}
