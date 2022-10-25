package com.example.contactlist.presenter

import com.example.contactlist.temporarily.Contact


interface MainAction {

    fun onAddContact(contacts: List<Contact>)

    fun onEditContact(contacts: List<Contact>)
}