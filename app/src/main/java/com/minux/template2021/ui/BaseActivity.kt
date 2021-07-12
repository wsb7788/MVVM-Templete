package com.minux.template2021.ui

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minux.template2021.ui.DefaultDialog

open class BaseActivity: AppCompatActivity(), View.OnClickListener, DefaultDialog.WekitDialogClickListener{
    override fun onClick(v: View?) {

    }

    fun showDialog(title: String){
        val dig = DefaultDialog(this)
        dig.listener = this
        dig.show(title)
    }

    override fun onOKClicked() {

    }
}