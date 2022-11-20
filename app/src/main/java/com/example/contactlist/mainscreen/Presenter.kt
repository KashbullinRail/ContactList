package com.example.contactlist.mainscreen

import com.example.contactlist.data.ContactRepository


class Presenter(private val contactRepository: ContactRepository) {

    private var mainAction: MainAction? = null


    fun initAction(mainAction: MainAction) {
        this.mainAction = mainAction
    }

    fun addContact(name: String, surname: String, number: String) {
        contactRepository.addContact(name, surname, number)
        mainAction?.onAddContact(contactRepository.getContacts())
    }

    fun editContact(name: String, surname: String, number: String) {
        contactRepository.editContact(name, surname, number)
        mainAction?.onAddContact(contactRepository.getContacts())
    }

    fun searchContact(nameSearch: String, surnameSearch:String) {
        contactRepository.searchContact(nameSearch, surnameSearch)
        mainAction?.onAddContact(contactRepository.getContacts())
    }
}