package com.example.testproject.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name = itemView.findViewById<TextView>(R.id.rv_tv_full_name)
    val username = itemView.findViewById<TextView>(R.id.rv_tv_username)
}