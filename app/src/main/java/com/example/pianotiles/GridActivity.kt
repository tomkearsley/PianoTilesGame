package com.example.pianotiles

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.grid.*
import java.util.*

class GridActivity: Activity(){
    val gameGrid = ArrayList<PianoTile>()

    val tiles = ArrayList<ArrayList<PianoTile>>()
    val whiteTile = PianoTile("White",R.drawable.white_piano_tile)
    val blackTile = PianoTile("Black",R.drawable.black_piano_tile)

    override fun onCreate(savedInstanceState: Bundle?) {
        var currentScore = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid)
        gameGrid.addAll(generateRow())
        gameGrid.addAll(generateRow())
        gameGrid.addAll(generateRow())





        var adapter = GridViewAdapter(this,gameGrid)
        startGame(currentScore)
        grid.adapter = adapter

    }

    fun startGame(currentScore : Int){
        grid.setOnItemClickListener{parent, view, position, id ->
            val tile:PianoTile = grid.adapter.getItem(position) as PianoTile
            println(tile)
            if(tile.color == "Black")
            {
                val column = position%4
                val row = position/4
                Toast.makeText(this,"row: $row, column: $column",Toast.LENGTH_SHORT).show()
                deleteRow()
            } else
            {
                Toast.makeText(this,"Game Over",Toast.LENGTH_SHORT).show()
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
}