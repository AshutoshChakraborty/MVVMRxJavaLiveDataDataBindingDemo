package com.example.mvvm_rxjava_livedata_databinding_demo.data

import com.example.mvvm_rxjava_livedata_databinding_demo.data.remote.Service
import com.example.rxfastnetworkarchitechturedemo.data.locale.pref.PrefManager

interface IDataManager {
    fun getPrefManager(): PrefManager
    fun getRetrofitService(): Service?
}