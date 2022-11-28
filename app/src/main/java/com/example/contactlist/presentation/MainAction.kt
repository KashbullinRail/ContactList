package com.example.contactlist.presentation

import com.example.contactlist.data.model.Contact


interface MainAction {

    fun onAddContact(contacts: List<Contact>)


    fun onEditContact(contacts: List<Contact>)
}