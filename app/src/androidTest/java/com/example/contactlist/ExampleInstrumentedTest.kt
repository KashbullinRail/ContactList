package com.example.contactlist

import android.content.Context
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.contactlist.app.presentation.MainActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule
import kotlin.reflect.typeOf

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

        clickOnButton(R.id.fabAddContact)
        clickOnButton(R.id.btnCancel)

        clickOnButton(R.id.fabAddContact)
        writeTextInField(R.id.etName, "Ivan")
        writeTextInField(R.id.etSurname, "Patanin")
        writeTextInField(R.id.etNumber, "293423959")
        clickOnButton(R.id.btnSave)

        clickOnButton(R.id.fabAddContact)
        writeTextInField(R.id.etName, "Pavel")
        writeTextInField(R.id.etSurname, "Fedotov")
        writeTextInField(R.id.etNumber, "37473328")
        clickOnButton(R.id.btnSave)

        clickOnButton(R.id.fabAddContact)
        writeTextInField(R.id.etName, "Fedor")
        writeTextInField(R.id.etSurname, "Karamba")
        writeTextInField(R.id.etNumber, "43675675")
        clickOnButton(R.id.btnSave)

        clickOnButton(R.id.rvContacts)


    }

}

fun clickOnButton(id: Int) {
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