package com.example.testproject.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.testproject.data.UserLightVersion

class UserDiffUtil(
    private val oldList: List<UserLightVersion>,
    private val newList: List<UserLightVersion>
) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}