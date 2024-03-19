package com.example.testproject.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name: TextView = itemView.findViewById(R.id.rv_tv_full_name)
    val username: TextView = itemView.findViewById(R.id.rv_tv_username)
}