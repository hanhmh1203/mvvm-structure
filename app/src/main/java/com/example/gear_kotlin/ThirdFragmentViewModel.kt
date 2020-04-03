package com.example.gear_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.UserModel

class ThirdFragmentViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var user = MutableLiveData<UserModel>()

    /**
     * postValue used in Background thread
     *
     */
    fun setUserName(otherName: String) {
        user.value!!.userName = otherName
        user.postValue(user.value)
    }

    /**
     * used in UI thread
     */
    fun setUserNameWithOut(otherName: String) {
        user.value = UserModel(otherName)
    }
}
