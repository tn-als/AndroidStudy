package com.tnals.week2.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.tnals.week2.People
import com.tnals.week2.databinding.ItemMeBinding

class MyViewHolder(private val binding: ItemMeBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(myData: People.Me) {
        with(binding) {
            ivMyProfile.setImageResource(myData.profileImage)
            tvMyName.text = myData.name
            tvMySelfdescription.text = myData.selfDescription
        }
    }
}