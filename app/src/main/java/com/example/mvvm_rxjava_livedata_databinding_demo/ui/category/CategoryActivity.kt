package com.example.mvvm_rxjava_livedata_databinding_demo.ui.category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_rxjava_livedata_databinding_demo.R
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        val viewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        viewModel.getCategoryResponse().observe(this, Observer {
            text.text = it.toString()

        })


    }
}
