package com.example.contactlist.presentation

import com.example.contactlist.presentation.repository.ContactRepository


class Presenter(private val contactRepository: ContactRepository) {

    private var mainAction: MainAction? = null

    fun initAction(mainAction: MainAction) {
        this.mainAction = mainAction
    }

    fun addContact(name: String, surname: String, number: String) {
        contactRepository.addContact(name, surname, number)
        mainAction?.onAddContact(contactRepository.getContacts())
    }

    fun editContact(id:String,name: String = "", surname: String = "", number: String = "", removeFlag:Boolean = false) {
        contactRepository.editContact(id, name, surname, number, removeFlag)
        mainAction?.onAddContact(contactRepository.getContacts())
    }

}