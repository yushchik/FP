package com.example.fp.thirdLab

import android.annotation.SuppressLint
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.annotation.RequiresApi
import android.util.Log
import android.util.Pair
import android.widget.Button
import android.widget.TextView
import com.example.fp.R
import java.io.File
import java.io.FileReader
import java.io.LineNumberReader
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.ArrayList

class Fifth2Activity : AppCompatActivity() {

    lateinit var edPeople: TextView
    lateinit var edTaxi: TextView
    lateinit var btnfifth: Button
    var mapPeople = ArrayList<String>()
    val mapTaxi = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        edTaxi = findViewById(R.id.edTaxi)
        edPeople = findViewById(R.id.edPeople)
        btnfifth = findViewById(R.id.btnfifth)
        btnfifth.setOnClickListener { view -> result() }

        secondTask()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun secondTask(){
        var text = "fgtg rere, wertj. ETE fgtg grg r lrlrlg fkfkfkfk"
        var textArray = text.split( ", ", ". ", "'"," ")
        val words = textArray.map { it }
        Log.d("RESULT SECOND TASK", words.toString())
        words.groupingBy { it }.eachCount()
        Log.d("RESULT SECOND TASK",  words.groupingBy { it }.eachCount().toString())
    }

    @SuppressLint("LongLogTag")
    fun result() {
        mapPeople.clear()
        val p = edPeople.text.toString().split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        Collections.addAll(mapPeople, *p)
        Log.d("RESULT mapPeople", mapPeople.toString())
        mapTaxi.clear()
        val t = edTaxi.text.toString().split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        Collections.addAll(mapTaxi, *t)
        Log.d("RESULT mapTaxi", mapTaxi.toString())
        val newPeople = mapPeople.withIndex().map { it }.sortedBy { it.value }
        Log.d("RESULT 56", newPeople.toString())
        val newTaxi = mapTaxi.withIndex().map { it }.sortedBy { it.value }.reversed()
        Log.d("RESULT 56", newTaxi.toString())

        Log.d("RESULT 56", newPeople.zip(newTaxi).toString())
        Log.d("RESULT 56", newPeople.zip(newTaxi).map { it.first.value to it.second.value }.toString())
        Log.d("RESULT 56", newPeople.zip(newTaxi).sortedBy { it.first.index }.map { it.first.value to it.second.value }.toString())

        Log.d("RESULT IN FUNCTIONAL STYLE",
                edPeople
                        .text
                        .toString()
                        .split(" "
                                .toRegex())
                        .dropLastWhile {
                            it.isEmpty()
                        }
                        .toTypedArray()
                        .withIndex()
                        .map {
                            it
                        }
                        .sortedBy {
                            it.value
                        }
                        .zip(
                                edTaxi
                                        .text
                                        .toString()
                                        .split(" "
                                                .toRegex())
                                        .dropLastWhile {
                                            it.isEmpty()
                                        }
                                        .toTypedArray()
                                        .withIndex()
                                        .map {
                                            it
                                        }
                                        .sortedBy {
                                            it.value
                                        }
                                        .reversed())
                        .sortedBy {
                            it.first.index
                        }
                        .map {
                            it.first.value to it.second.value
                        }
                        .toString())
    }
}

