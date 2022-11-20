package com.example.contactlist.data.model

import android.util.Log
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

    override fun searchContact(nameSearch: String, surnameSearch: String): Contact? {
        val db1 = realm.where(Contact::class.java)
            .equalTo("name", "$nameSearch")
            .findAll()
        Log.d("DEBUG1", "$db1")
        val db2 = realm.where(Contact::class.java)
            .equalTo("surname", "$surnameSearch")
            .findFirst()
        Log.d("DEBUG2", "$db2")
        val id = db2?.id.toString()
        val name = db2?.name.toString()
        val surname = db2?.surname.toString()
        val number = db2?.number.toString()
        val searchContact = listOf(id, name, surname, number)
        return db2
    }

    override fun getContacts(): List<Contact> {
        return realm.where(Contact::class.java).findAll().sort("surname", Sort.ASCENDING)
    }


}