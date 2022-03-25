package com.mark.appquiz.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val id: Long, val nickName: String, val imageUrl: String) : Parcelable
