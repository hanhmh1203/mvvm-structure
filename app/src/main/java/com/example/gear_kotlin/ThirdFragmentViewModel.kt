package com.example.gear_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.UserModel

class ThirdFragmentViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var user = MutableLiveData<UserModel>()
    fun setUserName(ortherName: String) {
        user.value!!.userName = ortherName
        user.postValue(user.value)
    }
    fun setUserNameWithOut(ortherName: String) {
        user.value = UserModel(ortherName)

    }
}
