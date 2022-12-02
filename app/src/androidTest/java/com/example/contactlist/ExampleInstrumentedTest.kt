package com.example.contactlist

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
        onView(withId(R.id.fabAddContact))
            .check(matches(isDisplayed()))
            .perform(click())

        val name = "Gevorg"

        onView(withId(R.id.etName))
            .check(matches(isDisplayed()))
            .perform(typeText(name))
            .check(matches(withText(name)))

        val surname = "Gegurgoshvili"

        onView(withId(R.id.etSurname))
            .check(matches(isDisplayed()))
            .perform(typeText(surname))
            .check(matches(withText(surname)))

        val phoneNumber = "34634636"

        onView(withId(R.id.etNumber))
            .check(matches(isDisplayed()))
            .perform(typeText(phoneNumber))
            .check(matches(withText(phoneNumber)))

        onView(withId(R.id.btnSave))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.rvContacts))
            .check(matches(isDisplayed()))
            .perform(click())

    }

}