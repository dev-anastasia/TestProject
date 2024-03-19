package com.example.testproject.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.testproject.R
import com.example.testproject.UsersViewModel

class ListFragment: Fragment(R.layout.fragment_list) {

    private val vm: UsersViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)


    }
}