package com.example.pianotiles

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.grid.*
import java.util.*

class GridActivity: Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        val currentScore = 0;
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid)

        val whiteTile = PianoTile("White",R.drawable.white_piano_tile)
        val blackTile = PianoTile("Black",R.drawable.black_piano_tile)
        val tileRow = ArrayList<PianoTile>()
        tileRow.add(blackTile)
        tileRow.add(whiteTile)
        tileRow.add(whiteTile)
        tileRow.add(whiteTile)
        val tiles = ArrayList<PianoTile>()
        for (i in 1..5){
            Collections.shuffle(tileRow)
            tiles.addAll(tileRow)

        }









        val adapter = GridViewAdapter(this,tiles)

        grid.adapter = adapter
        startGame(currentScore)

    }

    fun startGame(currentScore : Int){
        grid.setOnItemClickListener{parent, view, position, id ->
        }
    }

    fun generateRow(){
    }
}