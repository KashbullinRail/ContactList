package com.example.contactlist.feature.presentation

import com.example.contactlist.feature.data.model.Contact


interface MainAction {

    fun onAddContact(contacts: List<Contact>)

    fun onEditContact(contacts: List<Contact>)

}