package com.example.fp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnFirstLab);
      //  text = findViewById(R.id.tvMain);
        btn.setOnClickListener(view ->
        {   Intent intent = new Intent(this, FirstLab.class);
            startActivity(intent); } );
//        btn.setOnClickListener(view ->
//                text.setText("Yes"));
    }
}
