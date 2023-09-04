package com.agusoft.conversor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.agusoft.conversor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        vm.getMutable().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                binding.txResultado.setText(aDouble.toString());
            }
        });
        binding.btConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.convertirDinero(binding.etDolares.getText().toString(),binding.etEuros.getText().toString(),binding.rbDolares.isChecked(),binding.rbEuros.isChecked());
            }
        });

        binding.rbDolares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEuros.setEnabled(false);
                binding.etEuros.setText("");
                binding.etDolares.setEnabled(true);
            }
        });

        binding.rbEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEuros.setEnabled(true);
                binding.etDolares.setText("");
                binding.etDolares.setEnabled(false);
            }
        });
    }
}