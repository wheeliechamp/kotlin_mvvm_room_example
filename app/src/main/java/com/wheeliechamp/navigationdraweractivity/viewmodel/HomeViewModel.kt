package com.wheeliechamp.navigationdraweractivity.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Room
import com.wheeliechamp.navigationdraweractivity.model.User
import com.wheeliechamp.navigationdraweractivity.room.UserDao
import com.wheeliechamp.navigationdraweractivity.room.UserDatabase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    lateinit var mUserDao: UserDao
    lateinit var context: Context

    init {
        Log.d("Test", "Init")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text
    val countText = MutableLiveData<String>("MutableLiveData<String>")

    fun start() {
    }

    var count: Int = 0
    var isRun: Boolean = true

    fun btnStartClick() {
        Log.d("Test", "btnStartClick!!")
        viewModelScope.launch() {
            // 1秒おきのループ処理
            while(isRun) {
                countText.value = count.toString()
                Log.d("Test", count.toString())
                delay(1000L)
                count++
            }
            Log.d("Test", "viewModelScope")
        }
        mUserDao = UserDatabase.getInstance(context).userDao()
        insertUser()
    }

    fun btnStopClick() {
        isRun = false
        Log.d("Test", "btnStopClick!!")
    }

    private fun insertUser() {
        val newUser = User(0, "Taro", "Yamada")
        mUserDao.insertAll(newUser)
        Log.d("Test", mUserDao.getAll().toString())
    }

}
