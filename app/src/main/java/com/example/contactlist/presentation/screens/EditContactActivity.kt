package com.example.contactlist.presentation.screens

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contactlist.KEY_ITEM_ID
import com.example.contactlist.KEY_ITEM_NAME
import com.example.contactlist.KEY_ITEM_NUMBER
import com.example.contactlist.KEY_ITEM_SURNAME
import com.example.contactlist.databinding.ActivityEditContactBinding
import com.example.contactlist.presentation.MainAction
import com.example.contactlist.data.model.Contact
import com.example.contactlist.presentation.Presenter
import org.koin.android.ext.android.inject


class EditContactActivity : AppCompatActivity(), MainAction {

    private lateinit var binding: ActivityEditContactBinding

    private val presenter: Presenter by inject()
//    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.initAction(this)

        val itemID = intent.getStringExtra(KEY_ITEM_ID).toString()
        val itemName = intent.getStringExtra(KEY_ITEM_NAME)
        val itemSurname = intent.getStringExtra(KEY_ITEM_SURNAME)
        val itemNumber = intent.getStringExtra(KEY_ITEM_NUMBER)


        binding = ActivityEditContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            etNameEdit.setText(itemName)
            etSurnameEdit.setText(itemSurname)
            etNumberEdit.setText(itemNumber)
        }

        binding.btnCancel.setOnClickListener {
            startActivity(Intent(this@EditContactActivity, MainActivity::class.java))
            finish()
        }

        binding.btnSearch.setOnClickListener {
            with(binding) {
                Log.d("DEBUG", "нажатие кнопки поиск")
                if (etNameSearch.text.toString().isEmpty()
                    || etSurnameSearch.text.toString().isEmpty()
                ) {
                    Toast.makeText(
                        this@EditContactActivity,
                        "Поля поиска не заполнены",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    presenter.searchContact(
                        id = itemID.toString()
                    )
                }
            }
        }


        with(binding) {
            btnSaveEdit.setOnClickListener {
                presenter.editContact(
                    id = itemID.toString(),
                    name = etNameEdit.text.toString(),
                    surname = etSurnameEdit.text.toString(),
                    number = etNumberEdit.text.toString()
                )
                startActivity(Intent(this@EditContactActivity, MainActivity::class.java))
                finish()
            }
            btnDelete.setOnClickListener {
                presenter.editContact(
                    id = itemID.toString(),
                    removeFlag = true
                )
                startActivity(Intent(this@EditContactActivity, MainActivity::class.java))
                finish()
            }
        }


    }

    override fun onEditContact(contacts: List<Contact>) {
    }

    override fun onAddContact(contacts: List<Contact>) {
    }


}