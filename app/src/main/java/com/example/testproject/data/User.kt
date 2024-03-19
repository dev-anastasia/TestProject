package com.example.testproject.data

data class User(
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val address: UserAddress,
    val phone: String,
    val website: String,
    val company: UserCompany
)