package com.example.testproject.dagger2

import com.example.testproject.UsersRepository
import com.example.testproject.repo.UsersRepositoryImpl
import com.example.testproject.ui.fragments.ListFragment
import com.example.testproject.ui.fragments.UserInfoFragment
import dagger.Binds
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UserSubcomponent::class])
interface AppComponent {

    //fun create(): UserSubcomponent.Factory

    fun inject(fr: ListFragment)

    fun inject(fr: UserInfoFragment)
}