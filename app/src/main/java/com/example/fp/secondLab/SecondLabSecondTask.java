package com.example.fp.secondLab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fp.R;

import java.util.ArrayList;

public class SecondLabSecondTask extends AppCompatActivity {

    TextView tvResult;
    Button btnCalculate;
    EditText etNumber;
    ArrayList<Integer> list = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_lab_second_task);

        tvResult = findViewById(R.id.tvResult);
        etNumber = findViewById(R.id.etNumber);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(view -> calculete());
    }

    public void calculete() {
        int maxNum = Integer.valueOf(etNumber.getText().toString());
        for (int num = 1; num <= maxNum; num++)
            if (perfectNum(num)) {
                int i_sumDiv = 0;
                for (int j = 1; j <= (num / 2); j++) {
                    if (num % j == 0)
                        i_sumDiv = i_sumDiv + j;
                }
                if (i_sumDiv == num)
                    list.add(num);
//                    Log.d("RESULT SECOND TASK",list.toString());
            }

        tvResult.setText(list.toString());

    }


    public static Boolean perfectNum(int num) {
        // a variable that holds the sum of the factors
        int sum = 0;

        for (int factor = 1; factor < num; factor++) {
            if (num % factor == 0) {
                sum += factor;
            }
        }

        if (sum == num) {
            return true;
        } else {
            return false;
        }
    }

}
