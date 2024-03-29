package com.example.pianotiles

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.grid.*
import java.util.*

class GridActivity: Activity(){
    val gameGrid = ArrayList<PianoTile>()
    var currentScore = 0


    val tiles = ArrayList<ArrayList<PianoTile>>()
    val whiteTile = PianoTile("White",R.drawable.white_piano_tile)
    val blackTile = PianoTile("Black",R.drawable.black_piano_tile)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid)







        var adapter = GridViewAdapter(this,gameGrid)
        resetGrid()
        grid.adapter = adapter

    }

    fun startGame(){
        var scoreText:TextView = findViewById(R.id.currentScore)
        grid.setOnItemClickListener{parent, view, position, id ->
            val tile:PianoTile = grid.adapter.getItem(position) as PianoTile
            if(tile.color == "Black")
            {
                currentScore++
                val currentScoreLabel = getString(R.string.score_string)
                scoreText.setText("$currentScoreLabel"+ " $currentScore")
                deleteRow()
            } else
            {

                Toast.makeText(this,"Game Over!",Toast.LENGTH_LONG).show()
                val intent = Intent(this,GameOver::class.java)
                intent.putExtra("userScore",currentScore.toString())
                resetGrid()
                startActivity(intent)
            }

        }
    }

    fun generateRow(): ArrayList<PianoTile> {
        var tileRow = ArrayList<PianoTile>()
        tileRow.add(PianoTile("White",R.drawable.white_piano_tile))
        tileRow.add(PianoTile("White",R.drawable.white_piano_tile))
        tileRow.add(PianoTile("White",R.drawable.white_piano_tile))
        tileRow.add(PianoTile("Black",R.drawable.black_piano_tile))
        Collections.shuffle(tileRow)
        return tileRow
    }

    fun deleteRow()
    {
        for (i in 0..3)
        {

            gameGrid.removeAt(i)
        }
        gameGrid.addAll(generateRow())
        var adapter = GridViewAdapter(this,gameGrid)
        grid.adapter = adapter
    }

    fun resetGrid(){
        gameGrid.clear()
        currentScore = 0

        gameGrid.addAll(generateRow())
        gameGrid.addAll(generateRow())
        gameGrid.addAll(generateRow())
        startGame()

    }
}