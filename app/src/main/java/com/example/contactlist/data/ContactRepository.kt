package com.example.contactlist.data

import com.example.contactlist.data.model.Contact

interface ContactRepository {

    fun addContact(name: String, surname: String, number: String)

    fun editContact(name: String, surname: String, number: String)

    fun searchContact(nameSearch: String): Contact?

    fun getContact(): List<Contact>

}
