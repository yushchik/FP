package com.example.fp.firstLab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.fp.R;

import butterknife.ButterKnife;

public class FirstLab extends AppCompatActivity {

    Button btnFirstTask, btnSecondTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_lab);
        ButterKnife.bind(this);
        btnFirstTask = findViewById(R.id.btnFirstTask);
        btnSecondTask = findViewById(R.id.btnSecondTask);
        btnFirstTask.setOnClickListener(view -> {
            Intent intent = new Intent(this, FirstTaskActivity.class);
            startActivity(intent);
        });

        btnSecondTask.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondTaskFirstLabActivity.class);
            startActivity(intent);
        });
    }
}
