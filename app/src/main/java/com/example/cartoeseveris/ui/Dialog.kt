package com.example.cartoeseveris.ui

import android.app.AlertDialog
import android.view.View

class Dialog {
    private lateinit var alertBuilder: AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog

    fun dialogInstance(view: View, title: String?, text: String?) {

        alertBuilder = AlertDialog.Builder(view.context)
        alertDialog = alertBuilder
            .setTitle(title)
            .setMessage(text)
            .create()
        alertDialog.show()
    }
}