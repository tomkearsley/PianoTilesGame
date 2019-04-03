package com.example.pianotiles

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.game_over.*

class GameOver: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_over)
        val scoreField:TextView = findViewById(R.id.userScore)
        val userScore: String = intent.getStringExtra("userScore")
        scoreField.setText(userScore)

        val submitScore : Button = findViewById(R.id.submitButton)
        submitScore.setOnClickListener{
                val name = findViewById<EditText>(R.id.nameEntry)
                if (name != null)
                {
                    Toast.makeText(this,"Score Added!",Toast.LENGTH_SHORT).show()
                    intent = Intent(this,Leaderboard::class.java)
                    println(name.text)
                    intent.putExtra("score","${name.text}: $userScore")
                    startActivity(intent)
                    finish()
                }

        }



    }
}