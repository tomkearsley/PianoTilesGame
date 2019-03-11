package com.example.pianotiles

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class GridViewAdapter(val context: Context, val rowofButtons: List<String>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)

        val gridItem = view.findViewById<AppCompatTextView>(R.id.item_text_view)


        return view
    }

    override fun getItem(position: Int): Any {
        return rowofButtons[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return rowofButtons.size
    }
}