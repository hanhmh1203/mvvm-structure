package com.example.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*
import java.util.concurrent.TimeUnit

@Entity
data class UserGit (
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("login")
    val login: String,

    @SerializedName("avatar_url")
    val avatarUrl: String,

    @SerializedName("name")
    val name: String?,

    @SerializedName("company")
    val company: String?,

    @SerializedName("blog")
    val blog: String?,

    var lastRefreshed: Date
): BaseEntity() {
    /**
     * We consider that an [UserGit] is outdated when the last time
     * we fetched it was more than 10 minutes
     */
    fun haveToRefreshFromNetwork() : Boolean
            = TimeUnit.MILLISECONDS.toMinutes(Date().time - lastRefreshed.time) >= 10
}