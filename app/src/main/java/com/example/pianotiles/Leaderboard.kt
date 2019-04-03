package com.example.pianotiles

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.leaderboard.*

class Leaderboard: Activity() {
    var topScores = ArrayList<String>()

    private lateinit var listView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leaderboard)
        listView = findViewById<ListView>(R.id.leaderboardList)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, topScores)
        listView.adapter = adapter
        if (intent.extras != null){
            addScore(intent.getStringExtra("score"))
        }

    }

    fun addScore(score:String){
        topScores.add(score)
    }



}