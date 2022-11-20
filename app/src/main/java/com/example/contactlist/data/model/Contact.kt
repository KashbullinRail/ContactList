package com.example.contactlist.data.model

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.Required


@RealmClass
open class Contact : RealmModel {
    @PrimaryKey
    var id: String = ""

    @Required
    var name: String? = ""

    @Required
    var surname: String? = ""

    @Required
    var number: String? = ""
}