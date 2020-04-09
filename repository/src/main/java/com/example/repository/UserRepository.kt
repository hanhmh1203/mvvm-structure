package com.example.repository

import androidx.lifecycle.MutableLiveData
import com.example.local.dao.UserDao
import com.example.model.User
import com.example.remote.RedditApi



class UserRepository(private val dao: UserDao) {
    suspend fun getAllUser(): MutableLiveData<List<User>> {
        val data = MutableLiveData<List<User>>()
        data.postValue(dao.getAll())
        return data
    }
    suspend fun getAllUserList(): List<User> {
        return dao.getAll()
    }

    suspend fun insert(user: User){
        dao.insert(user)
    }
    suspend fun delete(user: User){
        dao.delete(user)
    }
    suspend fun deleteAll(){
        dao.deleteAll()
    }
    fun getUserDummy(): List<User>{
        val users = arrayListOf<User>()
        listOf<Int>(1,2,3,4,5).forEach {
            users.add(User(it, "hanh $it",  address = "HCM $it", phoneNumber = "090 $it" ))
        }
        return users
    }

}


