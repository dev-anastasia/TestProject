package com.example.testproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.UserViewHolder
import com.example.testproject.data.User

class UsersAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private val list = mutableListOf<User>()

    fun updateList(newList: List<User>) {
        val diffCallback = UserDiffUtil(list, newList)
        val result = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_view, parent, false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.username.text = list[position].username
    }
}