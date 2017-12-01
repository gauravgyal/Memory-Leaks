package com.example.gauravgoyal.memoryleaksexample

import android.app.Application
import com.squareup.leakcanary.LeakCanary

/**
 * Created by gauravgoyal on 30/11/17.
 */
class MemoryApplication : Application(){


    override fun onCreate(){
        super.onCreate()
        LeakCanary.install(this)
    }
}