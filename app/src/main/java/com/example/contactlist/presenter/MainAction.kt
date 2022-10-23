package com.example.realmdatabase.presenter

import com.example.contactlist.Contact


interface MainAction {

    fun onAddContact(contacts: List<Contact>)
}