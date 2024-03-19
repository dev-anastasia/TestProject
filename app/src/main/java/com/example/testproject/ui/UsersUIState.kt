package com.example.testproject.ui

sealed class UsersUIState {

    data object Loading : UsersUIState()

    data object Success : UsersUIState()

    data object Error : UsersUIState() {
        const val listErrorMessage: String = "Непредвиденная ошибка. Пожалуйста, попробуйте снова"
        const val userInfoErrorMessage: String = "Не удалось загрузить информацию о пользователе"
    }
}