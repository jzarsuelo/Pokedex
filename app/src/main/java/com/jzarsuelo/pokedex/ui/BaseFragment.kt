package com.jzarsuelo.pokedex.ui

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.jzarsuelo.pokedex.util.Message

abstract class BaseFragment : Fragment() {

    private var snackbar: Snackbar? = null

    fun showMessage(message: Message, actionTitle: String, action: () -> Unit) {
        if (message is Message.ErrorMessage) {
            snackbar = Snackbar.make(requireView(), message.message, Snackbar.LENGTH_INDEFINITE)
                    .setAction(actionTitle) { action() }
            snackbar?.show()
        } else if (snackbar != null){
            snackbar?.dismiss()
            snackbar = null
        }
    }

}