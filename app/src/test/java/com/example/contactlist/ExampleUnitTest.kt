package com.example.contactlist


import com.example.contactlist.app.viewModel.MainViewModel
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testViewModel() {

        val viewModel = MainViewModel
        viewModel.addContact(
            name = "ergerger",
            surname = "rdghrt",
            number = "453633643"
        )

    }

}