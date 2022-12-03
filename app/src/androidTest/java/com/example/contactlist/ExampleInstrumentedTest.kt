package com.example.contactlist

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.contactlist.app.presentation.MainActivity
import kotlinx.coroutines.delay
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {


    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkAllComponentIsVisible_Success() {

        clickOn(R.id.fabAddContact)
        clickOn(R.id.btnCancel)

        clickOn(R.id.fabAddContact)
        writeTextInField(R.id.etName, "AAA")
        writeTextInField(R.id.etSurname, "AAAAA")
        writeTextInField(R.id.etNumber, "11111111")
        clickOn(R.id.btnSave)

        clickOn(R.id.fabAddContact)
        writeTextInField(R.id.etName, "BBB")
        writeTextInField(R.id.etSurname, "BBBBB")
        writeTextInField(R.id.etNumber, "22222222")
        clickOn(R.id.btnSave)

        clickOn(R.id.fabAddContact)
        writeTextInField(R.id.etName, "CCC")
        writeTextInField(R.id.etSurname, "CCCCC")
        writeTextInField(R.id.etNumber, "33333333")
        clickOn(R.id.btnSave)

        clickOn(R.id.fabAddContact)
        writeTextInField(R.id.etName, "DDD")
        writeTextInField(R.id.etSurname, "DDDDD")
        writeTextInField(R.id.etNumber, "44444444")
        clickOn(R.id.btnSave)

        clickOn(R.id.fabAddContact)
        writeTextInField(R.id.etName, "EEE")
        writeTextInField(R.id.etSurname, "EEEEE")
        writeTextInField(R.id.etNumber, "55555555")
        clickOn(R.id.btnSave)

        clickOn(R.id.fabAddContact)
        writeTextInField(R.id.etName, "FFF")
        writeTextInField(R.id.etSurname, "FFFFF")
        writeTextInField(R.id.etNumber, "66666666")
        clickOn(R.id.btnSave)

        clickOn(R.id.rvContacts)
        clickOn(R.id.btnCancel)

        clickOn(R.id.rvContacts)
        writeEditTextInField(R.id.etNameEdit, "XX")
        writeEditTextInField(R.id.etSurnameEdit, "NN")
        writeEditTextInField(R.id.etNumberEdit, "00")
        clickOn(R.id.btnSaveEdit)

        clickOn(R.id.rvContacts)
        clickOn(R.id.btnDelete)

        clickOn(R.id.rvContacts)
        pressBack()

        clickOn(R.id.rvContacts)
        clickOn(R.id.btnDelete)

    }

}

fun clickOn(id: Int) {
    onView(withId(id))
        .check(matches(isDisplayed()))
        .perform(click())
}

fun writeTextInField(id: Int, text: String) {
    onView(withId(id))
        .check(matches(isDisplayed()))
        .perform(typeText(text))
        .check(matches(withText(text)))
}

fun writeEditTextInField(id: Int, text: String) {
    onView(withId(id))
        .check(matches(isDisplayed()))
        .perform(typeText(text))
}

