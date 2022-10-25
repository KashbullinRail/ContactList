package com.example.contactlist

import com.example.contactlist.temporarily.Contact
import io.realm.Realm
import io.realm.RealmModel

interface ContactRepository {

    fun addContact(name: String, surname: String, number: String)

    fun editContact(name: String, surname: String, number: String)

    fun getContact(): List<Contact>

}
