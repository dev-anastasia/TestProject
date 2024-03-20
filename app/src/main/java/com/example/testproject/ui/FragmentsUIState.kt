package com.example.testproject.ui

sealed class FragmentsUIState {

    data object Loading : FragmentsUIState()

    data object Success : FragmentsUIState()

    data object Error : FragmentsUIState() {
        const val listErrorMessage: String = "Непредвиденная ошибка. Пожалуйста, попробуйте снова"
        const val userInfoErrorMessage: String = "Не удалось загрузить информацию о пользователе"
    }
}