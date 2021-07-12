package com.minux.template2021.ui

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment

open class BaseFragment: Fragment(), View.OnClickListener, DefaultDialog.WekitDialogClickListener {
    override fun onClick(v: View?) {

    }

    fun showDialog(title: String, context: Context){
        val dig = DefaultDialog(context)
        dig.listener = this
        dig.show(title)
    }

    override fun onOKClicked() {

    }
}