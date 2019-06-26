package com.example.mvvm_rxjava_livedata_databinding_demo.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_rxjava_livedata_databinding_demo.app.MainApp
import com.example.mvvm_rxjava_livedata_databinding_demo.pojo.CategoriesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CategoryViewModel : ViewModel() {
    private val compositDisposable: CompositeDisposable = CompositeDisposable()
    private val retrofitService = MainApp().getDataManager().getRetrofitService()

    private val categoryResponse = MutableLiveData<CategoriesResponse>()


    fun getCategoryResponse(): LiveData<CategoriesResponse> {
        return categoryResponse
    }

    private fun fetchApi() {
        retrofitService?.getCategories()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribe(
                {
                    successResponse ->
                    categoryResponse.value = successResponse
                },
                {
                    error ->
                    Log.e("error", error.message)

                }
        )?.let {
            compositDisposable.add(it)

        }
    }
    init {
        fetchApi()
    }

}