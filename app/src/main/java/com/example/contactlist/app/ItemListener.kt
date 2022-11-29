package com.example.contactlist.app

import com.example.contactlist.data.model.Contact

interface ItemListener {

    fun onClick(contact: Contact?)

}