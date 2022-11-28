package com.example.contactlist.presentation.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contactlist.REGEX_PHONE_NUMBER
import com.example.contactlist.databinding.ActivityAddContactBinding
import com.example.contactlist.data.model.Contact
import com.example.contactlist.presentation.MainAction
import com.example.contactlist.presentation.Presenter
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
            phoneNumberRevisor()
        }

        binding.btnCancel.setOnClickListener {
            startMainActivity()
        }

    }

    private fun phoneNumberRevisor() {
        with(binding) {
            val r = Regex(REGEX_PHONE_NUMBER)
            if (r.matches(etNumber.text.toString())) {
                presenter.addContact(
                    name = etName.text.toString(),
                    surname = etSurname.text.toString(),
                    number = etNumber.text.toString()
                )
                startMainActivity()
            } else Toast
                .makeText(applicationContext, "номер телефона введен не верно", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this@AddContactActivity, MainActivity::class.java))
        finish()
    }

    override fun onAddContact(contacts: List<Contact>) {
        Toast.makeText(this, contacts.last().name, Toast.LENGTH_SHORT).show()
    }

    override fun onEditContact(contacts: List<Contact>) {
    }
}