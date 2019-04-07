package com.example.pianotiles

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.JsonReader
import android.util.JsonWriter
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.leaderboard.*
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Leaderboard: Activity() {
    var topScores = ArrayList<String>()
    private lateinit var listView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leaderboard)
        listView = findViewById<ListView>(R.id.leaderboardList)
        if (intent.extras != null){
            topScores = intent.getStringArrayListExtra("leaderboard")
        }


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, topScores)
        listView.adapter = adapter


    }

    override fun onStop() {
        super.onStop()
        val file = openFileOutput("leaderboard.json", Context.MODE_PRIVATE)
        val writer = JsonWriter(OutputStreamWriter(file))
        writer.setIndent(" ")
        writer.beginObject()
        for (each in topScores){
            writer.name("Person").value("$each")
        }
        writer.endObject()


    }

    override fun onStart() {
        super.onStart()
        try {
            val file = openFileInput("leaderboard.json")
        } catch(e: FileNotFoundException){

        }



    }



}