package ru.lapov.forrabitresult

import android.app.Application
import com.google.firebase.FirebaseApp

class FourRabitApp: Application() {

    override fun onCreate() {
        FirebaseApp.initializeApp(this)
        super.onCreate()
    }
}