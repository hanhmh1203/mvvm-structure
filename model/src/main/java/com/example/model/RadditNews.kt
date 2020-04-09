package com.example.model

import java.io.Serializable

data class RadditNews(
    val after: String,
    val before: String,
    val news: List<RedditNewsItem>
) : Serializable

data class RedditNewsItem(
    val author: String,
    val title: String,
    val numComments: Int,
    val created: Long,
    val thumbnail: String,
    val url: String?
) : Serializable