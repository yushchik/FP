package com.example.fp.secondLab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.fp.R;

import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.lang.String.valueOf;

public class SecondLabFirstTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_lab_first_task);

        int arr3[] = {220, 1184, 1210, 2, 5, 284};
        int n3 = arr3.length;
        Log.d("RESULT", "2 лабораторная");
        Log.d("RESULT", "Количество " + valueOf(countPairs2(arr3, n3)));

        int arr4[] = {2620, 2924, 5020, 5564, 6232, 6368};
        int n4 = arr4.length;
        Log.d("RESULT", "Количество " + valueOf(countPairs2(arr4, n4)));
        int limit = 10000;
        Map<Long, Long> map = LongStream.rangeClosed(1, limit)
                .parallel()
                .boxed()
                .collect(Collectors.toMap(Function.identity(), SecondLabFirstTask::properDivsSum));

        LongStream.rangeClosed(1, limit)
                .forEach(n -> {
                    long m = map.get(n);
                    if (m > n && m <= limit && map.get(m) == n)
                        Log.d("RESULT", valueOf(n) + " " + valueOf(m));
                });

    }

    public static Long properDivsSum(long n) {
        return LongStream.rangeClosed(1, (n + 1) / 2).filter(i -> n % i == 0).sum();
    }

    static int sumOfDiv(int x) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                sum += i;

                if (x / i != i)
                    sum += x / i;
            }
        }

        return sum;
    }

    static boolean isAmicable(int a, int b) {
        return (sumOfDiv(a) == b &&
                sumOfDiv(b) == a);
    }

    static int countPairs(int arr[], int n) {
        int count = 0;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (isAmicable(arr[i], arr[j]))
                    count++;

        return count;
    }


    /* 2 version*/

    // Calculate the sum
// of proper divisors
    static int sumOfDiv2(int x) {
        // 1 is a proper divisor
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                sum += i;

                // To handle perfect squares
                if (x / i != i)
                    sum += x / i;
            }
        }
        return sum;
    }

    // Check if pair is amicable
    static boolean isAmicable2(int a, int b) {
        return (sumOfDiv2(a) == b &&
                sumOfDiv2(b) == a);
    }

    // This function prints count
// of amicable pairs present
// in the input array
    static int countPairs2(int arr[], int n) {
        // Map to store the numbers
        HashSet<Integer> s = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < n; i++)
            s.add(arr[i]);

        // Iterate through each number,
        // and find the sum of proper
        // divisors and check if it's
        // also present in the array
        for (int i = 0; i < n; i++) {
            if (s.contains(sumOfDiv2(arr[i]))) {
                // It's sum of proper divisors
                int sum = sumOfDiv2(arr[i]);
                if (isAmicable(arr[i], sum))
                    count++;
            }
        }

        // As the pairs are counted
        // twice, thus divide by 2
        return count / 2;
    }

}
