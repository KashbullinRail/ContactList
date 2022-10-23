package com.example.realmdatabase.di

import com.example.contactlist.ContactRepository
import com.example.contactlist.ContactRepositoryImpl
import com.example.contactlist.MainViewModel
import com.example.contactlist.Presenter
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    single<Realm> {
        Realm.init(androidApplication())

        val configuration = RealmConfiguration.Builder()
            .name("todo.db")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .build()

        Realm.setDefaultConfiguration(configuration)

        Realm.getDefaultInstance()
    }

    single<ContactRepository> {
        ContactRepositoryImpl(realm = get())
    }

    viewModel {
        MainViewModel(contactRepository = get())
    }

    single {
        Presenter(contactRepository = get())
    }
}