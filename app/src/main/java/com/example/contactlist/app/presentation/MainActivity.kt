package com.example.contactlist.app.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.contactlist.KEY_ITEM_ID
import com.example.contactlist.KEY_ITEM_NAME
import com.example.contactlist.KEY_ITEM_NUMBER
import com.example.contactlist.KEY_ITEM_SURNAME
import com.example.contactlist.data.model.Contact
import com.example.contactlist.databinding.ActivityMainBinding
import com.example.contactlist.domain.adapter.ContactsAdapter
import com.example.contactlist.app.ItemListener
import com.example.contactlist.app.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity(), LifecycleObserver, ItemListener {

    private lateinit var binding: ActivityMainBinding
    private val adapter = ContactsAdapter(this)

    private val defaultLifecycleObserver = object : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            super.onCreate(owner)
            Log.d("Main", "DefaultLifecycleObserver - onCreate")
        }

        override fun onStart(owner: LifecycleOwner) {
            super.onStart(owner)
            Log.d("Main", "DefaultLifecycleObserver - onStart")
        }

        override fun onResume(owner: LifecycleOwner) {
            super.onResume(owner)
            Log.d("Main", "DefaultLifecycleObserver - onResume")
        }
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(defaultLifecycleObserver)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.allContacts.observe(this) {
            adapter.setData(it)
        }

        binding.rvContacts.adapter = adapter

        binding.fabAddContact.setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
            finish()
        }

    }


    override fun onClick(contact: Contact?) {
        val idItem = contact?.id.toString()
        val nameItem = contact?.name.toString()
        val surnameItem = contact?.surname.toString()
        val numberItem = contact?.number.toString()
        Toast.makeText(
            this,
            "выбран ${contact?.name} ${contact?.surname}",
            Toast.LENGTH_SHORT
        ).show()
        startActivity(Intent(this, EditContactActivity::class.java).apply {
            putExtra(KEY_ITEM_ID, idItem)
            putExtra(KEY_ITEM_NAME, nameItem)
            putExtra(KEY_ITEM_SURNAME, surnameItem)
            putExtra(KEY_ITEM_NUMBER, numberItem)
        })
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(defaultLifecycleObserver)
    }


}