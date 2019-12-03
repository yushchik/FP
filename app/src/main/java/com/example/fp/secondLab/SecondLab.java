package com.example.fp.secondLab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.fp.R;
import com.example.fp.firstLab.SecondTaskFirstLabActivity;

public class SecondLab extends AppCompatActivity {

    Button btnFirstTask, btnSecondTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_lab);

        btnFirstTask = findViewById(R.id.btnFirstTask);
        btnSecondTask = findViewById(R.id.btnSecondTask);
        btnFirstTask.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondLabFirstTask.class);
            startActivity(intent);
        });

        btnSecondTask.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondLabSecondTask.class);
            startActivity(intent);
        });
    }
}
