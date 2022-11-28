package com.example.contactlist.data.repository

import android.util.Log
import com.example.contactlist.data.model.Contact
import com.example.contactlist.presentation.repository.ContactRepository
import io.realm.Realm
import io.realm.Sort
import io.realm.kotlin.deleteFromRealm
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

    override fun editContact(
        id: String,
        name: String,
        surname: String,
        number: String,
        removeFlag: Boolean
    ) {
        realm.executeTransaction {
            if (!removeFlag) {
                it.where(Contact::class.java)
                    .equalTo("id", "$id")
                    .findFirst()
                    .apply {
                        this?.name = name
                        this?.surname = surname
                        this?.number = number
                    }
            } else {
              val data = it.where(Contact::class.java)
                    .equalTo("id", "$id")
                    .findFirst()
                data?.deleteFromRealm()

            }

        }
    }

    override fun searchContact(id: String): Contact? {
        val db2 = realm.where(Contact::class.java)
            .equalTo("surname", "$id")
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