package com.example.model

import java.io.Serializable

data class User(var id: Int =1 , var name: String = "hanh") : Serializable{
    var phoneNumber: String = "0906653665"
    var address: String = "bui quang la"
}