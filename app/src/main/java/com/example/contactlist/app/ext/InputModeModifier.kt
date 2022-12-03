package com.example.contactlist.app.ext

import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner


fun Fragment.modifyInputMode(softInputMode: Int): InputModeModifier =
    InputModeModifier(this, softInputMode)

val Fragment.viewLifecycle get() = viewLifecycleOwner.lifecycle

class InputModeModifier(private val fragment: Fragment, private val softInputMode: Int) {

    private val previosSoftInputMode: Int = fragment.requireActivity().window.attributes.softInputMode
    private val lifecycleObserver = ModifySoftInputModelLifecycleObserver()

    init {
        changeSoftInputModeToNow()
        fragment.viewLifecycle.addObserver(lifecycleObserver)
    }

    fun changeSoftInputModeToNow() {
        setSoftInputMode(softInputMode)
    }

    fun changeSoftInputModeBack() {
        setSoftInputMode(previosSoftInputMode)
    }

    private fun removeObserver() {
        fragment.viewLifecycle.removeObserver(lifecycleObserver)
    }

    private fun setSoftInputMode(softInputMode: Int){
        fragment.requireActivity().window.setSoftInputMode(softInputMode)
    }

    private inner class ModifySoftInputModelLifecycleObserver: DefaultLifecycleObserver {

        override fun onResume(owner: LifecycleOwner) {
            super.onResume(owner)
            changeSoftInputModeToNow()
        }

        override fun onPause(owner: LifecycleOwner) {
            super.onPause(owner)
            changeSoftInputModeBack()
        }

        override fun onDestroy(owner: LifecycleOwner) {
            super.onDestroy(owner)
            removeObserver()
        }

    }

}