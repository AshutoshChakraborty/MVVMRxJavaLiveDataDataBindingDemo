package com.example.mvvm_rxjava_livedata_databinding_demo.data.remote

import android.content.Context
import com.example.mvvm_rxjava_livedata_databinding_demo.R
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Sdk(private val retrofit: Retrofit) {
    private  var service: Service? = null

    init {
        createService()
    }

    /**
     * Builder for [MySdk]
     */
    class Builder {

        /**
         * Create the [MySdk] to be used.
         *
         * @return [MySdk]
         */

        fun build(context: Context): Sdk {
            val retrofit: Retrofit
            val baseUrl: String = context.resources.getString(R.string.base_url)

            val okHttpClient = InterceptorHTTPClientCreator.okHttpClient
            if (okHttpClient != null) {
                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .baseUrl(baseUrl)
                    .build()

                return Sdk(retrofit)
            } else {
                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(baseUrl)
                    .build()
            }
            return Sdk(retrofit)
        }
    }

    private fun createService() {
        service = retrofit.create(Service::class.java)
    }

    fun getService(): Service? {
        return service
    }
}