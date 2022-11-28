package com.example.contactlist.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactlist.data.model.Contact
import com.example.contactlist.data.model.ContactLiveData
import com.example.contactlist.presentation.repository.ContactRepository

class EditViewModel(private val contactRepository: ContactRepository):ViewModel() {

    val contact: ContactLiveData

        get() = getContact() as ContactLiveData

    fun addContact(name: String, surname: String) {

//        contactRepository.searchContact(id)
    }


    private fun getContact(): MutableLiveData<Contact> {
        val contact = ContactLiveData()
//        val selectedContacts = contactRepository.searchContact()
//        contact.value = selectedContacts
        return TODO()
    }

}