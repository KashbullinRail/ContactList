package com.example.contactlist.feature.data.model

import com.example.contactlist.feature.data.ContactRepository
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


    override fun getContacts(): List<Contact> {
        return realm.where(Contact::class.java).findAll().sort("surname", Sort.ASCENDING)
    }

}