package com.example.contactlist.temporarily

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.contactlist.temporarily.Contact


class ContactLiveData : MutableLiveData<List<Contact>>() {

    override fun onActive() {
        super.onActive()
        Log.d("ContactLiveData", "ContactLiveData - onActive")
    }

    override fun onInactive() {
        super.onInactive()
        Log.d("ContactLiveData", "ContactLiveData - onInactive")
    }
}