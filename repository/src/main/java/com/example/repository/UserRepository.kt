package com.example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.local.AppDatabase
import com.example.local.dao.UserDaoIn
import com.example.model.User

class UserRepository(private val dao: UserDaoIn) {
    fun getAllUser(): LiveData<List<User>> {
        val data = MutableLiveData<List<User>>()
        data.value = dao.getAll()
        return data
    }
    fun insert(user: User){
        dao.insert(user)
    }
    fun delete(user: User){
        dao.delete(user)
    }
    fun getUserDummy(): List<User>{
        val users = arrayListOf<User>()
        listOf<Int>(5).forEach {
            users.add(User(it, "hanh $it",  address = "HCM $it", phoneNumber = "090 $it" ))
        }
        return users
    }
}