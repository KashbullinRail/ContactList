package com.example.contactlist.mainscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactlist.data.ContactRepository
import com.example.contactlist.data.model.Contact
import com.example.contactlist.data.model.ContactLiveData

class EditViewModel(private val contactRepository: ContactRepository):ViewModel() {

    val contact: ContactLiveData

        get() = getContact() as ContactLiveData

    fun addContact(name: String, surname: String) {

        contactRepository.searchContact(name, surname)
    }


    private fun getContact(): MutableLiveData<Contact> {
        val contact = ContactLiveData()
//        val selectedContacts = contactRepository.searchContact()
//        contact.value = selectedContacts
        return TODO()
    }

}