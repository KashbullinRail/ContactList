package com.example.contactlist.feature.presentation

import com.example.contactlist.feature.data.model.Contact

interface ItemListener {

    fun onClick(contact: Contact?)

}