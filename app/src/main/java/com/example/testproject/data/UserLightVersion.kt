package com.example.testproject.data

// В отличие от data class User, здесь содержится только базовая информация о пользователях,
// необходимая для RecyclerView. Такое разделение нужно для того, чтобы не загружать лишнюю
// информацию при получении всего списка пользователей

data class UserLightVersion(
    val id: Long,
    val name: String,
    val username: String
)
