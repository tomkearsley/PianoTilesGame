package com.example.pianotiles

import android.app.Activity
import android.os.Bundle

class GridActivity: Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid)
    }
}