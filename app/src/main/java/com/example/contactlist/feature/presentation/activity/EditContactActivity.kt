package com.example.contactlist.feature.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contactlist.*
import com.example.contactlist.databinding.ActivityEditContactBinding
import com.example.contactlist.feature.presentation.MainAction
import com.example.contactlist.feature.data.model.Contact
import com.example.contactlist.feature.domain.Presenter
import com.example.contactlist.ext.focusAndShowKeyboard
import org.koin.android.ext.android.inject


class EditContactActivity : AppCompatActivity(), MainAction {

    private lateinit var binding: ActivityEditContactBinding
    private val presenter: Presenter by inject()
    private val itemID by lazy { intent.getStringExtra(KEY_ITEM_ID).toString() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.initAction(this)

        val itemName = intent.getStringExtra(KEY_ITEM_NAME)
        val itemSurname = intent.getStringExtra(KEY_ITEM_SURNAME)
        val itemNumber = intent.getStringExtra(KEY_ITEM_NUMBER)

        binding = ActivityEditContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etNameEdit.focusAndShowKeyboard()

        with(binding) {
            etNameEdit.setText(itemName)
            etSurnameEdit.setText(itemSurname)
            etNumberEdit.setText(itemNumber)

            btnCancel.setOnClickListener {
                startMainActivity()
            }

            btnSaveEdit.setOnClickListener {
                phoneNumberRevisor()
            }

            btnDelete.setOnClickListener {
                presenter.editContact(
                    id = itemID.toString(),
                    removeFlag = true
                )
                startMainActivity()
            }
        }

    }

    private fun phoneNumberRevisor() {
        with(binding) {
            val r = Regex(REGEX_PHONE_NUMBER)
            if (r.matches(etNumberEdit.text.toString())) {
                presenter.editContact(
                    id = itemID.toString(),
                    name = etNameEdit.text.toString(),
                    surname = etSurnameEdit.text.toString(),
                    number = etNumberEdit.text.toString()
                )
                startMainActivity()
            } else Toast
                .makeText(applicationContext, "номер телефона введен не верно", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this@EditContactActivity, MainActivity::class.java))
        finish()
    }

    override fun onEditContact(contacts: List<Contact>) {
    }

    override fun onAddContact(contacts: List<Contact>) {
    }

}