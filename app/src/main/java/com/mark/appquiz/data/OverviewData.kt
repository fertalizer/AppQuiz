package com.mark.appquiz.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
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
    val creationDate: String,
    val id: Long = -1): Parcelable
