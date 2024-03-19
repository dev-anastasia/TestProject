package com.example.testproject.repo

import com.example.testproject.UsersRepository
import com.example.testproject.data.User
import com.example.testproject.data.UserLightVersion
import com.example.testproject.network.RetrofitObject
import io.reactivex.Single
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor() : UsersRepository {

    override fun getUsersList(): Single<List<UserLightVersion>> {
        return RetrofitObject.usersService.getUsersList()
    }

    override fun getUserInfo(id: Long): Single<List<User>> {
        return RetrofitObject.usersService.getUserInfo(id)
    }
}