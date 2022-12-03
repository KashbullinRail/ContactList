package com.example.contactlist


import org.junit.Test
import kotlin.test.assertEquals


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {


    @Test
    fun testViewModel() {

        val contactRepoTest = ContactRepositoryTest()

        val name = "Ivans"

        val contact = FakeContact(
            name = "Ivan",
            surname = "Makarov",
            phone = "55555333"
        )

        contactRepoTest.addContactTest(contact)
        val list = contactRepoTest.getAllContactTest()
        val lastContact = list.last()

        assertEquals(contact, lastContact)
        assertEquals(name, lastContact.name)

    }

}