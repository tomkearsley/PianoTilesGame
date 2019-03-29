package com.example.pianotiles

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_layout.view.*

class GridViewAdapter(val context: Context, val rowofButtons: ArrayList<PianoTile>) : BaseAdapter(){
    var gridCopy = rowofButtons

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val tile = gridCopy[position]
        var view: View = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        view.imgTile.setImageResource(tile.image!!)
        return view

    }



    override fun getItem(position: Int): PianoTile {
        return rowofButtons[position]
    }

    override fun getItemId(position: Int): Long {
        return rowofButtons.size - position.toLong()
    }

    override fun getCount(): Int {
        return rowofButtons.size
    }
}