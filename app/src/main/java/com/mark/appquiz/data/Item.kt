package com.mark.appquiz.data

sealed class Item {
    abstract val id: Long

    data class Title(val title: String): Item() {
        override val id: Long
            get() = -1
    }

    data class Full(val title: String): Item() {
        override val id: Long
            get() = -1
    }

}