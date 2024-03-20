package com.example.testproject.ui.adapter

// Интерфейс для общения UsersAdapter и ListFragment

interface ClickListener {

    fun onUserClicked(userId: Long)
}