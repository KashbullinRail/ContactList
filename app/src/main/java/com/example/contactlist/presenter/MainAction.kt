package com.example.contactlist.presenter

import com.example.contactlist.Contact


interface MainAction {

    fun onAddContact(contacts: List<Contact>)
}