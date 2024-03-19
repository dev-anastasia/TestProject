package com.example.testproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UsersViewModelFactory(private val repo: UsersRepository) : ViewModelProvider.Factory { // @Inject constructor

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(repo) as T
    }
}