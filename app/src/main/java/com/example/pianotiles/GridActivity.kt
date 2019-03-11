package com.example.pianotiles

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.grid.*

class GridActivity: Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        val currentScore = 0;
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid)

        val tiles = ArrayList<PianoTile>()

        tiles.add(PianoTile("White",R.drawable.white_piano_tile))
        tiles.add(PianoTile("White",R.drawable.white_piano_tile))
        tiles.add(PianoTile("White",R.drawable.white_piano_tile))


        val adapter = GridViewAdapter(this,tiles)

        grid.adapter = adapter
        startGame(currentScore)

    }

    fun startGame(currentScore : Int){
        grid.setOnItemClickListener{parent, view, position, id ->
            Toast.makeText(this,"Clicked Item : " + position, Toast.LENGTH_SHORT).show()

        }
    }
}