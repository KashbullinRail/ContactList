package com.example.contactlist.data.model

import androidx.lifecycle.MutableLiveData

class EditContactLiveData: MutableLiveData<List<Contact>>() {

    override fun postValue(value: List<Contact>?) {
        super.postValue(value)
    }

    override fun setValue(value: List<Contact>?) {
        super.setValue(value)
    }
}