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

        val tiles = listOf<String>("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23")

        val adapter = GridViewAdapter(this,tiles)

        grid.adapter = adapter
        grid.setOnItemClickListener{parent, view, position, id ->
            Toast.makeText(this,"Clicked Item : " + position, Toast.LENGTH_SHORT).show()


        }
    }
}