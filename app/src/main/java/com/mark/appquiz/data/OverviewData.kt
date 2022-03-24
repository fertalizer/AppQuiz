package com.mark.appquiz.data

data class OverviewData(
    val title: String,
    val content: String,
    val imageUrls: List<String>,
    val user: User,
    val favoriteCount: Int,
    val likeCount: Int,
    val commentCount: Int,
    val unlockCount: Int,
    val type: Int,
    val tags: List<String>,
    val creationDate: String)
