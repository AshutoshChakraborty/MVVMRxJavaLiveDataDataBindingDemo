package com.example.mvvm_rxjava_livedata_databinding_demo.pojo


import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
        @SerializedName("categories")
        val categories: List<Category>
)

data class Category(
        @SerializedName("categories")
        val categories: CategoriesX
)

data class CategoriesX(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
)