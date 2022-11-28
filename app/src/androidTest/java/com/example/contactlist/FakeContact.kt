package com.example.contactlist

import android.os.Parcelable
import java.io.Serializable

data class FakeContact(
    val name: String,
    val surname: String,
    val phone: String
):Serializable