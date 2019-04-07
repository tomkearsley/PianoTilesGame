package com.example.pianotiles

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.game_over.*
import org.json.JSONObject
import java.io.BufferedInputStream
import java.net.URL
import java.nio.charset.Charset
import javax.net.ssl.HttpsURLConnection

class GameOver: Activity() {

    val KEY = "e7e05678509248ceb66524f05ad67670"
    val parameters = mapOf("sources" to "abc-news","apiKey" to KEY)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_over)
        val scoreField:TextView = findViewById(R.id.userScore)
        val userScore: String = intent.getStringExtra("userScore")
        scoreField.setText(userScore)

        val submitScore : Button = findViewById(R.id.submitButton)
        val playAgain : Button = findViewById(R.id.playAgain)
        val emailScore : Button = findViewById(R.id.emailScore)

        val headlineText : TextView = findViewById(R.id.headlineText)


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

        emailScore.setOnClickListener{
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.putExtra(Intent.EXTRA_TEXT,"I scored $userScore" +
                    "on Piano Tiles. Can you beat it?")
            emailIntent.type = "text/plain"
            startActivity(emailIntent)



        }

        playAgain.setOnClickListener{
            finish()
        }

        HeadlinesDownloader(this).execute()



    }
}