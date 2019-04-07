package com.example.pianotiles

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import kotlin.random.Random

class GameOver: Activity() {

    val KEY = "e7e05678509248ceb66524f05ad67670"
    val parameters = mapOf("sources" to "abc-news","apiKey" to KEY)
    var leaderboard = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_over)
        val scoreField:TextView = findViewById(R.id.userScore)
        val userScore: String = intent.getStringExtra("userScore")
        scoreField.setText(userScore)

        val playAgain : Button = findViewById(R.id.playAgain)
        val emailScore : Button = findViewById(R.id.emailScore)
        val submitScore : ToggleButton = findViewById(R.id.submitButton)

        val headlineText : TextView = findViewById(R.id.headlineText)

        submitScore.setOnCheckedChangeListener {_, isToggled ->
            if (isToggled){
                val name = findViewById<EditText>(R.id.nameEntry)
                if (name != null)
                {
                    Toast.makeText(this,"Score Added!",Toast.LENGTH_SHORT).show()
                    leaderboard.add("${name.text}: $userScore")
                    intent = Intent(this,Leaderboard::class.java)
                    intent.putStringArrayListExtra("leaderboard",leaderboard)
                    startActivity(intent)

                }
            } else{
                // Do Nothing.
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

        var headlines = HeadlinesDownloader(this).execute().get()
        val random = Random.nextInt(0,9)
        val headlineNote = getString(R.string.news_headline)
        headlineText.setText("$headlineNote " + headlines[random].text)



    }

}