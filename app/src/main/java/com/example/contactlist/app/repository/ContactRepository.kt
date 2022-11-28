package com.example.contactlist.app.repository

import com.example.contactlist.data.model.Contact

interface ContactRepository {

    fun addContact(name: String, surname: String, number: String)

    fun editContact(id: String, name: String, surname: String, number: String, removeFlag: Boolean)

    fun getContacts(): List<Contact>

}
