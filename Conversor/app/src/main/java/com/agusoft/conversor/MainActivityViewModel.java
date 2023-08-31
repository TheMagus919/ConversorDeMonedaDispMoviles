package com.agusoft.conversor;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.text.DecimalFormat;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Double> mutableResultado;
    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public LiveData<Double> getMutable(){
        if(mutableResultado == null){
            mutableResultado = new MutableLiveData<>();
        }
        return mutableResultado;
    }
    public void convertirDinero(String dolar, String euro, boolean dolarB, boolean euroB){
        Double res = (double) 0;
        if( dolarB && dolar.isEmpty()){
            Toast.makeText(context, "Porfavor ingresar un Valor.", Toast.LENGTH_SHORT).show();
        }else if(dolarB && Integer.parseInt(dolar) > 0){
            res = Double.parseDouble(dolar) * 0.92045;
            DecimalFormat df = new DecimalFormat("#.##");
            res = Double.valueOf(df.format(res));
        }else if(euroB && euro.isEmpty()){
            Toast.makeText(context, "Porfavor ingresar un Valor.", Toast.LENGTH_SHORT).show();
        } else if (euroB && Integer.parseInt(euro) > 0) {
            res = Double.parseDouble(euro) * 1.08429;
            DecimalFormat df = new DecimalFormat("#.##");
            res = Double.valueOf(df.format(res));
        }
        mutableResultado.setValue(res);
    }
}

