package com.example.testproject.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testproject.UsersRepository
import com.example.testproject.data.User
import com.example.testproject.data.UserLightVersion
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UsersViewModel @Inject constructor(private val repo: UsersRepository) : ViewModel() {

    val fragmentsUIState: LiveData<FragmentsUIState>
        get() = _uiState
    private val _uiState = MutableLiveData<FragmentsUIState>()

    val usersList: List<UserLightVersion>
        get() = _usersList
    private val _usersList = mutableListOf<UserLightVersion>()

    val currentUser: User?
        get() = _currentUser
    private var _currentUser: User? = null

    fun getUsersList() {
        _uiState.postValue(FragmentsUIState.Loading)

        repo.getUsersList()
            .subscribeOn(Schedulers.io())
            .subscribe(
                { list ->
                    _usersList.apply {
                        clear()
                        addAll(list)
                    }
                    _uiState.postValue(FragmentsUIState.Success)
                },
                { error ->
                    _uiState.postValue(FragmentsUIState.Error)
                    Log.e("RxJava", error.toString())
                })
    }

    fun getUserInfo(id: Long) {
        _uiState.postValue(FragmentsUIState.Loading)

        repo.getUserInfo(id)
            .subscribeOn(Schedulers.io())
            .subscribe(
                { list ->
                    if (list != null) {
                        _currentUser = list[0]
                        _uiState.postValue(FragmentsUIState.Success)
                    } else {
                        _uiState.postValue(FragmentsUIState.Error)
                        Log.e("RxJava", "user = null")
                    }
                },
                { error ->
                    _uiState.postValue(FragmentsUIState.Error)
                    Log.e("RxJava", error.toString())
                })
    }
}