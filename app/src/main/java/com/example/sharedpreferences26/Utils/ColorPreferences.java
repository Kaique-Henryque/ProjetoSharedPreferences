package com.example.sharedpreferences26.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.ColorSpace;

//criando a classe responsável por salvar dados no SharedPrefernces

public class ColorPreferences {
    private final SharedPreferences mSharedPreferences;

    public ColorPreferences (Context context){
        this.mSharedPreferences = context.getSharedPreferences("Cor26", Context.MODE_PRIVATE);
    }

    public void storeColor(String key, Integer value){
        //gravando no  SharedPReferences
        this.mSharedPreferences.edit().putInt(key, value).apply();
    }

    public int getStoredColor(String key){
        //Retornando valor no sharedPrefences

        //Nota: Retornando int pois o shared preferences não permite adicionar hexadecimal,
        //e não é possivel converter hexadecimal em string

        return this.mSharedPreferences.getInt(key, 1);
    }


}
