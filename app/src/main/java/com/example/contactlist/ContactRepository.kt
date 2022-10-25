package com.example.contactlist

import com.example.contactlist.temporarily.Contact

interface ContactRepository {

    fun addContact(name: String, surname: String, number: String)

    fun editContact()

    fun getContact(): List<Contact>
}