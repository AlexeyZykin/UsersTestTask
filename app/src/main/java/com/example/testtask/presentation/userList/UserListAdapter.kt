package com.example.testtask.presentation.userList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.R
import com.example.testtask.domain.model.UserDetails
import com.squareup.picasso.Picasso

class UserListAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>(), Mapper<List<UserDetails>> {

    private val list = mutableListOf<UserDetails>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_user,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position], clickListener)
    }

    override fun map(source: List<UserDetails>) {
        val diff = DiffUtil(list, source)
        val result = androidx.recyclerview.widget.DiffUtil.calculateDiff(diff)
        list.clear()
        list.addAll(source)
        result.dispatchUpdatesTo(this)
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName = view.findViewById<TextView>(R.id.tvName)
        private val tvAddress = view.findViewById<TextView>(R.id.tvAddress)
        private val tvPhoneNumber = view.findViewById<TextView>(R.id.tvPhoneNumber)
        private val userImage = view.findViewById<ImageView>(R.id.imageUser)
        private val userItem = view.findViewById<CardView>(R.id.cvUserItem)

        fun bind(userDetails: UserDetails, clickListener: ClickListener) {
            Picasso.get().load(userDetails.picture.large).into(userImage)
            tvName.text =
                "${userDetails.name.title} ${userDetails.name.first} ${userDetails.name.last}"
            tvAddress.text = "${userDetails.location.street.number}," +
                    " ${userDetails.location.street.name}" +
                    " ${userDetails.location.city}"
            tvPhoneNumber.text = userDetails.phone
            userItem.setOnClickListener {
                clickListener.click(userDetails)
            }

        }
    }

    interface ClickListener {
        fun click(userDetails: UserDetails)
    }

    class DiffUtil(
        private val oldList: List<UserDetails>,
        private val newList: List<UserDetails>
    ) : androidx.recyclerview.widget.DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size


        override fun getNewListSize() = newList.size


        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}