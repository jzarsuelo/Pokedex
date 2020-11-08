package com.jzarsuelo.pokedex.ui

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment : Fragment() {

    fun showMessage(message: String, actionTitle: String, action: () -> Unit) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_INDEFINITE)
            .setAction(actionTitle) { action() }
            .show()
    }

}