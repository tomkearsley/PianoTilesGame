package com.example.pianotiles

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playButton: Button = findViewById(R.id.playButton)
        playButton.setOnClickListener {
            val intent = Intent(this, GridActivity::class.java)
            startActivity(intent)
        }
        val leaderboardButton: Button = findViewById(R.id.leaderboardButton)
        leaderboardButton.setOnClickListener {
            val intent = Intent(this, Leaderboard::class.java)
            startActivity(intent)
        }
    }






}