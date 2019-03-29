package com.example.pianotiles

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.game_over.*

class GameOver: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_over)
        val scoreField:TextView = findViewById(R.id.userScore)
        val userScore: String = intent.getStringExtra("userScore")
        scoreField.setText(userScore)

    }
}