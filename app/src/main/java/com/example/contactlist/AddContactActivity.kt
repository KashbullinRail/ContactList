package com.example.contactlist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contactlist.databinding.ActivityAddContactBinding
import com.example.contactlist.presenter.MainAction
import com.example.contactlist.temporarily.Contact
import org.koin.android.ext.android.inject


class AddContactActivity : AppCompatActivity(), MainAction {

    private lateinit var binding: ActivityAddContactBinding

    private val presenter: Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.initAction(this)

        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            with(binding) {
                presenter.addContact(
                    name = etName.text.toString(),
                    surname = etSurname.text.toString(),
                    number = etNumber.text.toString()
                )
                startActivity(Intent(this@AddContactActivity, MainActivity::class.java))
                finish()
            }
        }
    }

    override fun onAddContact(contacts: List<Contact>) {
        Toast.makeText(this, contacts.last().name, Toast.LENGTH_SHORT).show()
    }
}