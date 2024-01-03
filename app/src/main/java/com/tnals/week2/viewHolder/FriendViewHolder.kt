package com.tnals.week2.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.tnals.week2.People
import com.tnals.week2.databinding.ItemFriendBinding

class FriendViewHolder(private val binding: ItemFriendBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(friendData: People.Friend) {
        with(binding) {
            ivFriendProfile.setImageResource(friendData.profileImage)
            tvFriendName.text = friendData.name
            tvFriendSelfdescription.text = friendData.selfDescription
            ivFriendBirthday.visibility = friendData.birthday
        }
    }
}