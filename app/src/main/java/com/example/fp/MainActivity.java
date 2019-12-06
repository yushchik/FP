package com.example.fp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.fp.firstLab.FirstLab;
import com.example.fp.fourthLaba.FourthLaba;
import com.example.fp.secondLab.SecondLab;

public class MainActivity extends AppCompatActivity {

    Button btn, btnSecondLab, btnFourthLab;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnFirstLab);
        btnSecondLab = findViewById(R.id.btnSecondLab);
        btnFourthLab = findViewById(R.id.btnFourthLab);
      //  text = findViewById(R.id.tvMain);
        btn.setOnClickListener(view ->
        {   Intent intent = new Intent(this, FirstLab.class);
            startActivity(intent); } );

        btnSecondLab.setOnClickListener(view ->
        {   Intent intent = new Intent(this, SecondLab.class);
            startActivity(intent); } );

        btnFourthLab.setOnClickListener(view ->
        {   Intent intent = new Intent(this, FourthLaba.class);
            startActivity(intent); } );

    }
}
