package com.example.testproject.network

import com.example.testproject.data.User
import com.example.testproject.data.UserLightVersion
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {

    @GET("users")
    fun getUsersList(): Single<List<UserLightVersion>>

    @GET("users")
    fun getUserInfo(@Query("id") id: Long): Single<List<User>>
}