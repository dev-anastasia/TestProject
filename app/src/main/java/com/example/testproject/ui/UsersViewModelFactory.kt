package com.example.testproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.UsersRepository
import javax.inject.Inject

class UsersViewModelFactory @Inject constructor(private val repo: UsersRepository) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(repo) as T
    }
}