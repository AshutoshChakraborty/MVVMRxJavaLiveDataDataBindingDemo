package com.example.mvvm_rxjava_livedata_databinding_demo.app

import android.app.Application
import android.content.Context
import com.example.mvvm_rxjava_livedata_databinding_demo.data.DataManager
import com.example.mvvm_rxjava_livedata_databinding_demo.data.remote.InterceptorHTTPClientCreator
lateinit var  context: Context
class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
        InterceptorHTTPClientCreator.createInterceptorHTTPClient(this)
    }

    fun getDataManager(): DataManager {
        return DataManager(context)
    }


}