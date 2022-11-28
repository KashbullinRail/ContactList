package com.example.contactlist.domain.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlist.databinding.ItemContactBinding
import com.example.contactlist.data.model.Contact
import com.example.contactlist.presentation.ItemListener


class ContactsAdapter(val itemListener: ItemListener) :
    ListAdapter<Contact, ContactsAdapter.MyViewHolder>(MyDiffUtil) {

    object MyDiffUtil : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id == newItem.id
        }
    }

    inner class MyViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact?, itemListener: ItemListener) {
            binding.tvNameAndSurname.text = "${contact?.surname} ${contact?.name}"
            binding.tvNumber.text = contact?.number

            itemView.setOnClickListener {
                itemListener.onClick(contact)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note = getItem(position)
        holder.bind(note, itemListener)
    }

    fun setData(allContacts: List<Contact>) {
        this.submitList(allContacts)
        notifyDataSetChanged()
    }

}