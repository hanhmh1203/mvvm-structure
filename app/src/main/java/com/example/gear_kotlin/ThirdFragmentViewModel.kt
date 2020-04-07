package com.example.gear_kotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.local.dao.UserDao
import com.example.model.User

class ThirdFragmentViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var users = MutableLiveData<List<User>>()
    var user = MutableLiveData<User>()
    lateinit var daoIn: UserDao
    init {
        user.value = User(1, "william")
    }
    /**
     * postValue used in Background thread
     *
     */
    fun setUserName(otherName: String) {
        user.value!!.name = otherName
        user.postValue(user.value)
    }

    /**
     * used in UI thread
     */
    fun setUserNameWithOut(otherName: String) {
        user.value = User(1, otherName)
    }
    var increase =0
    fun click(){
        increase++
        setUserNameWithOut("hanhmh1203 $increase")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ThirdFragment"," onCleared user value ${user.value!!.name}")
    }
}
