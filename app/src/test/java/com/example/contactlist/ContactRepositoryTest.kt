package com.example.contactlist

class ContactRepositoryTest() {

    private val contactList = mutableListOf<FakeContact>()

    fun addContactTest(contact: FakeContact){
        contactList.add(contact)
    }

    fun getAllContactTest(): MutableList<FakeContact> {
       return contactList
    }

}