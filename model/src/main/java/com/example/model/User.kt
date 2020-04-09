package com.example.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class User(@PrimaryKey var id: Int =1,
                @ColumnInfo(name = "name") var name: String = "hanh",
        @ColumnInfo(name = "phone_number")  var phoneNumber: String = "0906653665",
        @ColumnInfo(name = "address")  var address: String = "TP HCM") : Serializable{

}