package com.example.testproject

import com.example.testproject.data.User
import com.example.testproject.data.UserLightVersion
import io.reactivex.Single

interface UsersRepository {

    fun getUsersList(): Single<List<UserLightVersion>>

    fun getUserInfo(id: Long): Single<List<User>>
}