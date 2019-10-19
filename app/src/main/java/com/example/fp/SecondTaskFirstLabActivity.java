package com.example.fp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class SecondTaskFirstLabActivity extends AppCompatActivity {

    TextView tvResult, tvArray, tvCoin;
String s = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task_first_lab);
        tvResult = findViewById(R.id.tvResultSecondTask);
        tvCoin = findViewById(R.id.tvCoin);
        tvArray = findViewById(R.id.tvArray);
        int[] S = {1, 2};
        int N = 10;
        for(int i = 0; i < S.length; i++){
            s += String.valueOf(S[i]);
            s += " ";
        }
        int countR = findCombinationsCount(N, S, 0);
        tvArray.setText("Список номиналов: " + s);
        tvCoin.setText("Сумма: " + N);
        tvResult.setText("Количество вариантов: " + countR);
    }


    int findCombinationsCount(int amount, int coins[], int checkFromIndex) {
        if (amount == 0)
            return 1;
        else if (amount < 0 || coins.length == checkFromIndex)
            return 0;
        else {
            int withFirstCoin = findCombinationsCount(amount - coins[checkFromIndex], coins, checkFromIndex);
            int withoutFirstCoin = findCombinationsCount(amount, coins, checkFromIndex + 1);
            return withFirstCoin + withoutFirstCoin;
        }
    }
}
