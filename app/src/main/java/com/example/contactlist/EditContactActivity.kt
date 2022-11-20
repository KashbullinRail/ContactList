package com.example.contactlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contactlist.databinding.ActivityEditContactBinding
import com.example.contactlist.mainscreen.MainAction
import com.example.contactlist.data.model.Contact
import com.example.contactlist.mainscreen.Presenter
import org.koin.android.ext.android.inject


class EditContactActivity : AppCompatActivity(), MainAction {

    private lateinit var binding: ActivityEditContactBinding

    private val presenter: Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.initAction(this)

        binding = ActivityEditContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveEdit.setOnClickListener {

        }


        binding.btnCancel.setOnClickListener {
            startActivity(Intent(this@EditContactActivity, MainActivity::class.java))
            finish()
        }

        binding.btnSearch.setOnClickListener {
            with(binding) {
                presenter.editContact(
                    name = etNameEdit.text.toString(),
                    surname = etSurnameEdit.text.toString(),
                    number = etNumberEdit.text.toString()
                )

            }
        }

        binding.btnSaveEdit.setOnClickListener {
            with(binding){
                presenter.searchContact(
                    nameSearch = etNameSearch.text.toString()
                )
            }

        }

    }

    override fun onEditContact(contacts: List<Contact>) {
        TODO("Not yet implemented")
    }

    override fun onAddContact(contacts: List<Contact>) {
    }


}