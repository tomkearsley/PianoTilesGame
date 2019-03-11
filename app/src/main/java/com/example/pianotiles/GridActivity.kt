package com.example.pianotiles

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.grid.*

class GridActivity: Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid)

        val tiles = listOf<String>("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23")

        val adapter = GridViewAdapter(this,tiles)

        grid.adapter = adapter
    }
}