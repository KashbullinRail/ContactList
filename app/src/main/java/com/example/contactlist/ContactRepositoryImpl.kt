package com.example.contactlist

import com.example.contactlist.temporarily.Contact
import io.realm.Realm
import io.realm.Sort
import java.util.*


class ContactRepositoryImpl(
    private val realm: Realm
) : ContactRepository {
    override fun addContact(name: String, surname: String, number: String) {
        realm.executeTransaction {
            it.createObject(Contact::class.java, UUID.randomUUID().toString()).apply {
                this.name = name
                this.surname = surname
                this.number = number
            }
        }
    }

    override fun editContact() {
        realm.executeTransaction {

        }
    }

    override fun getContact(): List<Contact> {
        return realm.where(Contact::class.java).findAll().sort("name", Sort.ASCENDING)
    }

}