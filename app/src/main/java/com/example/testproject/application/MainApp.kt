package com.example.testproject.application

import android.app.Application
import com.example.testproject.dagger2.AppComponent
import com.example.testproject.dagger2.DaggerAppComponent

class MainApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}