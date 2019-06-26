package com.example.mvvm_rxjava_livedata_databinding_demo.data

import android.content.Context
import com.example.mvvm_rxjava_livedata_databinding_demo.app.MainApp
import com.example.mvvm_rxjava_livedata_databinding_demo.data.remote.Sdk
import com.example.mvvm_rxjava_livedata_databinding_demo.data.remote.Service
import com.example.rxfastnetworkarchitechturedemo.data.locale.pref.PrefManager

class DataManager(private val context: Context) : IDataManager {
    override fun getPrefManager(): PrefManager {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRetrofitService(): Service? = Sdk.Builder().build(context).getService()

}