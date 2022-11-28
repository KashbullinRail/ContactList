package com.example.contactlist.presentation

import com.example.contactlist.data.model.Contact

interface ItemListener {

    fun onClick(contact: Contact?)

}