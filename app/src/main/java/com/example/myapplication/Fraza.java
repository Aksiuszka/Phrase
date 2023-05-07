package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabela_frazy")
public class Fraza {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="fraza")
    private String mFraza;

    public Fraza(@NonNull String fraza){
        mFraza = fraza;

    }
    @NonNull
    public String getFraza(){
        return this.mFraza;
    }
}
