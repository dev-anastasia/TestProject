package com.example.testproject.dagger2

import com.example.testproject.UsersRepository
import com.example.testproject.ui.fragments.ListFragment
import com.example.testproject.ui.fragments.UserInfoFragment
import com.example.testproject.repo.UsersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Subcomponent

@Module
interface UserSubcomponent {

//    @Subcomponent.Factory
//    interface Factory {
//        fun create(): UserSubcomponent
//    }

    @Binds
    fun providesUsersRepo(impl: UsersRepositoryImpl): UsersRepository
}