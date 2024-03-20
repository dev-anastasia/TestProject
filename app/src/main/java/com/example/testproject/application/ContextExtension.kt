package com.example.testproject.application

import android.content.Context
import com.example.testproject.dagger2.AppComponent

val Context.component: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> applicationContext.component // рекурсивный вызов
    }