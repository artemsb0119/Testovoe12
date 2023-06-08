package com.example.testovoe12

import android.app.Application
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "33ed7b32-0869-48fd-824e-4645ab0749fd"

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}