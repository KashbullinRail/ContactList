package com.example.contactlist.presentation.repository

import com.example.contactlist.data.model.Contact

interface ContactRepository {

    fun addContact(name: String, surname: String, number: String)

    fun editContact(id: String, name: String, surname: String, number: String, removeFlag: Boolean)

    fun searchContact(id: String): Contact?

    fun getContacts(): List<Contact>

}
