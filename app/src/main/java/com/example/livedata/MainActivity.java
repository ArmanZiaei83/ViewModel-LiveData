package com.example.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button addNumberBtn , reset;
    TextView numberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNumberBtn = findViewById(R.id.addBtn);
        numberTextView = findViewById(R.id.num);
        reset = findViewById(R.id.reset);

        AddViewModel addViewModel = new ViewModelProvider(this).get(AddViewModel.class);
        addViewModel.getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                numberTextView.setText("Ur Number : " + integer);
            }
        });



        addNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addViewModel.addNum();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addViewModel.resetNum();
            }
        });
    }
}