package com.example.rxfastnetworkarchitechturedemo.data.locale.pref

import android.content.Context
import android.content.SharedPreferences
import com.example.mvvm_rxjava_livedata_databinding_demo.data.local.pref.IPrefManager


class PrefManager(context: Context) : IPrefManager {
    override var noOfkidsAdded: Int?
        get() = userPref?.getInt(KIDS_ADDED,0)
        set(currentPositionChild) {currentPositionChild?.let { userPref?.edit()?.putInt(
            KIDS_ADDED,it)?.apply()}}

    override var isFirstTime: Boolean?
        get() = nonLoginPref?.getBoolean(
            IS_FIRST_TIME,true)
        set(currentPositionChild) {currentPositionChild?.let { nonLoginPref?.edit()?.putBoolean(
            IS_FIRST_TIME,it)?.apply()}}

    override var planId: String?
        get() = userPref?.getString(
            PLAN_ID,"0")
        set(currentPositionChild) {currentPositionChild?.let { userPref?.edit()?.putString(
            PLAN_ID,it)?.apply()}}

    override var currentPositionChild: Int?
        get() = userPref?.getInt(CURRENT_POS_CHILD,0)
        set(currentPositionChild) {currentPositionChild?.let { userPref?.edit()?.putInt(
            CURRENT_POS_CHILD,it)?.apply()}}

    override var parentBearerToken: String?
        get() = userPref?.getString(
            BEARER_TOKEN,"")
        set(parentBearerToken) {parentBearerToken?.let { userPref?.edit()?.putString(
            BEARER_TOKEN,it)?.apply()}}

    override var parentId: String?
        get() = userPref?.getString(
            PARENT_ID,"")
        set(parentId) {parentId?.let { userPref?.edit()?.putString(
            PARENT_ID,it)?.apply()}}

    override var parentEmailId: String?
        get() = userPref?.getString(
            PARENT_EMAIL_ID,"")
        set(parentEmailId) {parentEmailId?.let { userPref?.edit()?.putString(
            PARENT_EMAIL_ID,it)?.apply()}}

    override var parentName: String?
        get() = userPref?.getString(
            PARENT_NAME,"")
        set(parentName) {parentName?.let { userPref?.edit()?.putString(
            PARENT_NAME,it)?.apply()}}

    override var noOfMaxKids: Int?
        get() = userPref?.getInt(PARENT_NO_OF_KIDS, 1)
        set(parentKids) = parentKids?.let { userPref?.edit()?.putInt(
            PARENT_NO_OF_KIDS, it)?.apply() }!!


    override var loginStatus: Boolean?
        get() = userPref?.getBoolean(
            LOGIN_STATUS, false)
        set(loginStatus) = loginStatus?.let { userPref?.edit()?.putBoolean(
            LOGIN_STATUS, it)?.apply() }!!

    init {
        userPref = context.getSharedPreferences(
            PREF_NAME, 0)
        nonLoginPref = context.getSharedPreferences(
            PREF_NN_LOGIN, 0)
    }

    override fun clearLogin() {
        userPref?.edit()?.clear()?.apply()
    }
    companion object {
        private val PREF_NAME :String= "user_preferences"
        private val PREF_NN_LOGIN :String= "nonlogin_preferences"
        private val PARENT_NO_OF_KIDS:String = "mobileno"
        private val PARENT_EMAIL_ID:String = "email_id"
        private val PARENT_NAME:String = "fname"
        private val PARENT_ID:String = "id"
        private val BEARER_TOKEN:String = "bearer_token"
        private val LOGIN_STATUS :String= "login_status"
        private val CURRENT_POS_CHILD :String= "current_pos_child"
        private val PLAN_ID :String= "plan_id"
        private val IS_FIRST_TIME :String= "is_first_time"
        private val KIDS_ADDED :String= "kids_added"
        private var userPref: SharedPreferences? = null
        private var nonLoginPref: SharedPreferences? = null
    }

}