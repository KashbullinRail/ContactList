package com.example.contactlist

import com.example.contactlist.presenter.MainAction


class Presenter(private val contactRepository: ContactRepository) {

    private var mainAction: MainAction? = null


    fun initAction(mainAction: MainAction) {
        this.mainAction = mainAction
    }

    fun addContact(name: String, surname: String, number: String) {
        contactRepository.addContact(name, surname, number)
        mainAction?.onAddContact(contactRepository.getContact())
    }

    fun editContact(name: String, surname: String, number: String) {
        contactRepository.editContact(name, surname,number)
        mainAction?.onAddContact(contactRepository.getContact())
    }
}