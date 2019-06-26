package com.example.mvvm_rxjava_livedata_databinding_demo.data.local.pref

interface IPrefManager {

    var planId: String?
    var noOfkidsAdded: Int?

    var isFirstTime: Boolean?

    var noOfMaxKids: Int?

    var parentEmailId: String?

    var parentName: String?

    var parentId: String?

    var parentBearerToken: String?

    var currentPositionChild: Int?

    var loginStatus: Boolean?

    fun clearLogin()

}
