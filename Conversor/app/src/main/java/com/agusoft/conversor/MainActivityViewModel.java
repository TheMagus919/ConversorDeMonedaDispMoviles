package com.agusoft.conversor;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
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

    public void convertirDolar(String valor){
        Double resultado = (Double) 0.00;
        if(valor.length() == 0){
            Toast.makeText(context, "Porfavor ingresar un Valor.", Toast.LENGTH_SHORT).show();
        }else{
            resultado = Double.parseDouble(valor) * 0.92045;
            DecimalFormat df = new DecimalFormat("#.##");
            resultado = Double.valueOf(df.format(resultado));
        }
        mutableResultado.setValue(resultado);
    }

    public void convertirEuro(String valor){
        Double resultado = (Double) 0.00;
        if(valor.length() == 0){
            Toast.makeText(context, "Porfavor ingresar un Valor.", Toast.LENGTH_SHORT).show();
        }else{
            resultado = Double.parseDouble(valor) * 1.08643;
            DecimalFormat df = new DecimalFormat("#.##");
            resultado = Double.valueOf(df.format(resultado));
        }
        mutableResultado.setValue(resultado);
    }
}
