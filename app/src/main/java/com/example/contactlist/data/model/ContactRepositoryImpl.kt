package com.example.contactlist.data.model

import com.example.contactlist.data.ContactRepository
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

    override fun editContact(name: String, surname: String, number: String) {
        realm.executeTransaction {
            it.where(Contact::class.java)
                .equalTo("name", "$name")
                .findFirst()
                .apply {
                    this?.name = name
                    this?.surname = surname
                    this?.number = number
                }
        }
    }

    override fun searchContact(nameSearch: String): Contact? {
          val db = realm.where(Contact::class.java)
                .equalTo("name", "$nameSearch")
                .findFirst()
        return db
    }

    override fun getContact(): List<Contact> {
        return realm.where(Contact::class.java).findAll().sort("name", Sort.ASCENDING)
    }

}