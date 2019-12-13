package com.example.fp.thirdLab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FifthActivity extends AppCompatActivity {


    TextView edPeople, edTaxi;
    Button btnfifth;
    ArrayList<String> mapPeople = new ArrayList<>();
    ArrayList<String> mapTaxi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        edTaxi = findViewById(R.id.edTaxi);
        edPeople = findViewById(R.id.edPeople);
        btnfifth = findViewById(R.id.btnfifth);

        btnfifth.setOnClickListener(view -> result());

    }

    public void result() {
        mapPeople.clear();
        ArrayList<String> mapTaxi = new ArrayList<>();
        String[] p = edPeople.getText().toString().split(" ");
        Collections.addAll(mapPeople, p);


        Log.d("RESULT 5", mapPeople.toString());

        mapTaxi.clear();
        String[] t = edTaxi.getText().toString().split(" ");
        Collections.addAll(mapTaxi, t);
        Log.d("RESULT 5", mapTaxi.toString());
        Pair<String, Integer> pair;
        ArrayList<Map<String, Integer>> sort = new ArrayList<>();
        // Collections.addAll(sort, new HashMap<>().putAll(mapPeople, 1)  );

//        Map<Integer,String > multimap = mapPeople
//                .stream()
//                .collect( Collectors.toMap(mapPeople,mapPeople.iterator(), Collectors.toList())));
        AtomicInteger index = new AtomicInteger();
//        Map<String, Integer> len2StringMap = mapPeople.stream()
//                .collect(Collectors.toMap(Function.identity(), mapPeople.iterator() , (oldValue, newValue) -> oldValue));
//        len2StringMap.forEach((key, value) -> System.out.println(key + " : " + value));


        Log.d("RESULT 56",  String.valueOf(Arrays.stream(p).map(str -> index.getAndIncrement() + " -> " + str)));
    }
}
