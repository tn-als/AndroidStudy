package com.tnals.week2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tnals.week2.viewHolder.FriendViewHolder
import com.tnals.week2.viewHolder.MyViewHolder
import com.tnals.week2.databinding.ItemFriendBinding
import com.tnals.week2.databinding.ItemMeBinding

class PeopleAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var peopleList: List<People> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_friend -> FriendViewHolder(
                ItemFriendBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

            else -> MyViewHolder(ItemMeBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = peopleList[position]

        when (holder) {
            is MyViewHolder -> holder.onBind(item as People.Me)
            is FriendViewHolder -> holder.onBind(item as People.Friend)
        }
    }

    override fun getItemCount() = peopleList.size
    override fun getItemViewType(position: Int) = when (peopleList[position]) {
        is People.Me -> R.layout.item_me
        is People.Friend -> R.layout.item_friend
    }

    fun setPeopleList(peopleList: List<People>) {
        this.peopleList = peopleList.toList()
        notifyDataSetChanged()
    }
}