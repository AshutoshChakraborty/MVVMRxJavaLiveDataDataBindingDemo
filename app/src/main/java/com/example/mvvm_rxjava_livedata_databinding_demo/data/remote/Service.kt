package com.example.mvvm_rxjava_livedata_databinding_demo.data.remote

import com.example.mvvm_rxjava_livedata_databinding_demo.pojo.CategoriesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface Service {
    @GET("/api/v2.1/categories")
    fun getCategories(): Single<CategoriesResponse>
}