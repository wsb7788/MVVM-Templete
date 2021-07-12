package com.minux.template2021.ui

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.TextView

class DefaultDialog(context: Context) {
    private val dlg = Dialog(context)   //부모 액티비티의 context 가 들어감
    private lateinit var mTvTitle : TextView
    private lateinit var btnOK : TextView
//    private lateinit var btnCancel : Button
    var listener : WekitDialogClickListener? = null

    fun show(title : String) {
        dlg.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dlg.setContentView(R.layout.dialog_wekit_v1)
        dlg.setCancelable(false)

//        mTvTitle = dlg.findViewById<TextView>(R.id.dialog_wekit_v1_title_tv)
        mTvTitle.text = title

//        btnOK = dlg.findViewById(R.id.dialog_wekit_v1_check_tv)
        btnOK.setOnClickListener {

            listener!!.onOKClicked()

            dlg.dismiss()
        }

//        btnCancel = dlg.findViewById(R.id.cancel)
//        btnCancel.setOnClickListener {
//            dlg.dismiss()
//        }

        dlg.show()
    }

    interface WekitDialogClickListener {
        fun onOKClicked()
    }
}