package com.example.fp;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstTaskActivity extends AppCompatActivity {


    TextInputEditText etFirst;


    TextInputEditText etSecond;

    Button btnpascalTriangle;


    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_task);
        ButterKnife.bind(this);
        btnpascalTriangle = findViewById(R.id.btnpascalTriangle);
        tvResult = findViewById(R.id.tvResult);
        etFirst = findViewById(R.id.etFirst);
        etSecond = findViewById(R.id.etSecond);
        btnpascalTriangle.setOnClickListener(view ->
        {
            tvResult.setText("Результат: " +
                    pascalTriangle(Integer.valueOf(etFirst.getText().toString()), Integer.valueOf(etSecond.getText().toString())));

        });
    }

    public long pascalTriangle(int r, int k) {
        if (r == 1 || k <= 1 || k >= r) return 1L;
        long rer = pascalTriangle(r - 1, k - 1) + pascalTriangle(r - 1, k);
        return rer;
    }
}
