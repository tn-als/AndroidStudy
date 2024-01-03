package com.tnals.week2

import androidx.annotation.DrawableRes

sealed class People {
    data class Me(
        @DrawableRes val profileImage: Int,
        val name: String,
        val selfDescription: String
    ) : People()

    data class Friend(
        @DrawableRes val profileImage: Int,
        val name: String,
        val selfDescription: String,
        val birthday: Int
    ) : People()
}