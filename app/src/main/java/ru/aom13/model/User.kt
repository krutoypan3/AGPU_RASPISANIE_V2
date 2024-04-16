package ru.aom13.model

import androidx.annotation.DrawableRes

data class User(
    @DrawableRes val photoResId: Int,
    val name: String,
    val status: String = "",
    val followersCount: Int,
    val followingCount: Int,
    val userId: Int,
)