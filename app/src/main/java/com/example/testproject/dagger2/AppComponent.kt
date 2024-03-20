package com.example.testproject.dagger2

import com.example.testproject.MainActivity
import com.example.testproject.ui.fragments.ListFragment
import com.example.testproject.ui.fragments.UserInfoFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositorySubcomponent::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    fun inject(fr: ListFragment)

    fun inject(fr: UserInfoFragment)
}