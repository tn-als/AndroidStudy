package com.tnals.week2

import android.view.View
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    fun makeList(user: User): List<People> {
        return listOf(
            People.Me(
                profileImage = R.drawable.ic_profile_white_24,
                name = user.nickname,
                selfDescription = user.aboutme
            ),
            People.Friend(
                profileImage = R.drawable.ic_profile_white_24,
                name = "전민주",
                selfDescription = "ihateava",
                birthday = View.VISIBLE
            ),
            People.Friend(
                profileImage = R.drawable.ic_profile_white_24,
                name = "노태윤",
                selfDescription = "areian13",
                birthday = View.INVISIBLE
            ),
            People.Friend(
                profileImage = R.drawable.ic_profile_white_24,
                name = "신현석",
                selfDescription = "brassgum",
                birthday = View.INVISIBLE
            ),
            People.Friend(
                profileImage = R.drawable.ic_profile_white_24,
                name = "김재민",
                selfDescription = "jj_m103",
                birthday = View.VISIBLE
            ),
            People.Friend(
                profileImage = R.drawable.ic_profile_white_24,
                name = "오렌지",
                selfDescription = "orange",
                birthday = View.INVISIBLE
            ),
            People.Friend(
                profileImage = R.drawable.ic_profile_white_24,
                name = "젤리",
                selfDescription = "jelly",
                birthday = View.VISIBLE
            ),
            People.Friend(
                profileImage = R.drawable.ic_profile_white_24,
                name = "라면",
                selfDescription = "ramen",
                birthday = View.INVISIBLE
            ),
            People.Friend(
                profileImage = R.drawable.ic_profile_white_24,
                name = "케이크",
                selfDescription = "cake",
                birthday = View.INVISIBLE
            ),
            People.Friend(
                profileImage = R.drawable.ic_profile_white_24,
                name = "스파게티",
                selfDescription = "spaghetti",
                birthday = View.INVISIBLE
            ),
            People.Friend(
                profileImage = R.drawable.ic_profile_white_24,
                name = "사과",
                selfDescription = "pqr",
                birthday = View.INVISIBLE
            )

        )
    }
}