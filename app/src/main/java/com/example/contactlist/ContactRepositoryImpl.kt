package com.example.contactlist

import com.example.contactlist.temporarily.Contact
import io.realm.Realm
import io.realm.RealmModel
import io.realm.Sort
import io.realm.kotlin.where
import org.koin.core.component.getScopeId
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