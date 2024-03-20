package com.example.testproject.dagger2

import com.example.testproject.UsersRepository
import com.example.testproject.repo.UsersRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositorySubcomponent {

    @Binds
    fun providesUsersRepo(impl: UsersRepositoryImpl): UsersRepository
}