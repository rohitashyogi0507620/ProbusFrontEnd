package `in`.probusinsurance.probusdesign.ui.dialog

import `in`.probusinsurance.probusdesign.R
import `in`.probusinsurance.probusdesign.ui.button.ButtonOutline
import `in`.probusinsurance.probusdesign.ui.button.ButtonRound
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

object AlertDialog {


    //Error Dialog
    fun ErrorDialog(context: Context, message: String): Dialog {
        val alertdialog = Dialog(context)
        alertdialog.setContentView(R.layout.error_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )

        val txtmessage: TextView = alertdialog.findViewById(R.id.txt_alerttitle)
        txtmessage.text = message
        val btncanle: ButtonOutline = alertdialog.findViewById(R.id.btn_cancle)
        btncanle.setOnClickListener {
            alertdialog.dismiss()
        }
        alertdialog.show()

        return alertdialog
    }

    fun ErrorDialog(context: Context, message: String, btntext: String): Dialog {
        val alertdialog = Dialog(context)
        alertdialog.setContentView(R.layout.error_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val txtmessage: TextView = alertdialog.findViewById(R.id.txt_alerttitle)
        txtmessage.text = message
        val btn: ButtonRound = alertdialog.findViewById(R.id.btn_ok)
        btn.setText(btntext)
        val btncanle: ButtonOutline = alertdialog.findViewById(R.id.btn_cancle)
        btncanle.setOnClickListener {
            alertdialog.dismiss()
        }
        alertdialog.show()
        return alertdialog
    }

    fun ErrorDialog(
        context: Context,
        title: String,
        message: String,
        btntext: String
    ): Dialog {
        val alertdialog = Dialog(context)
        alertdialog.setContentView(R.layout.error_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val txtmessage: TextView = alertdialog.findViewById(R.id.txt_alertmessage)
        txtmessage.visibility = View.VISIBLE
        txtmessage.text = message
        val txttitle: TextView = alertdialog.findViewById(R.id.txt_alerttitle)
        txttitle.text = title
        val btn: ButtonRound = alertdialog.findViewById(R.id.btn_ok)
        btn.setText(btntext)
        val btncanle: ButtonOutline = alertdialog.findViewById(R.id.btn_cancle)
        btncanle.setOnClickListener {
            alertdialog.dismiss()
        }
        alertdialog.show()
        return alertdialog
    }



    // Info Dialog
    fun InfoDialog(context: Context, message: String): Dialog {
        val alertdialog = Dialog(context)
        alertdialog.setContentView(R.layout.info_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val txtmessage: TextView = alertdialog.findViewById(R.id.txt_alerttitle)
        txtmessage.text = message
        val btncanle: ButtonOutline = alertdialog.findViewById(R.id.btn_cancle)
        btncanle.setOnClickListener {
            alertdialog.dismiss()
        }
        alertdialog.show()
        return alertdialog
    }

    fun InfoDialog(context: Context, message: String, btntext: String): Dialog {
        val alertdialog = Dialog(context)
        alertdialog.setContentView(R.layout.info_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val txtmessage: TextView = alertdialog.findViewById(R.id.txt_alerttitle)
        val btn: ButtonRound = alertdialog.findViewById(R.id.btn_ok)
        btn.setText(btntext)
        txtmessage.text = message
        val btncanle: ButtonOutline = alertdialog.findViewById(R.id.btn_cancle)
        btncanle.setOnClickListener {
            alertdialog.dismiss()
        }
        alertdialog.show()
        return alertdialog
    }

    fun InfoDialog(
        context: Context,
        title: String,
        message: String,
        btntext: String
    ): Dialog {
        val alertdialog = Dialog(context)
        alertdialog.setContentView(R.layout.info_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val txtmessage: TextView = alertdialog.findViewById(R.id.txt_alertmessage)
        txtmessage.visibility = View.VISIBLE
        txtmessage.text = message
        val txttitle: TextView = alertdialog.findViewById(R.id.txt_alerttitle)
        txttitle.text = title
        val btn: ButtonRound = alertdialog.findViewById(R.id.btn_ok)
        btn.setText(btntext)
        val btncanle: ButtonOutline = alertdialog.findViewById(R.id.btn_cancle)
        btncanle.setOnClickListener {
            alertdialog.dismiss()
        }
        alertdialog.show()
        return alertdialog
    }

    //Edit Dialog

    fun ExitDialog(context: Context): Dialog {
        val alertdialog = Dialog(context)
        alertdialog.setContentView(R.layout.alert_cancle_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val btncanle:ButtonOutline = alertdialog.findViewById(R.id.btn_cancle)
        btncanle.setOnClickListener {
            alertdialog.dismiss()
        }
        alertdialog.show()
        return alertdialog
    }
    fun ExitDialog(context: Context, title: String, message: String): Dialog {
        val alertdialog = Dialog(context)
        alertdialog.setContentView(R.layout.alert_cancle_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )

        val txttitle:TextView = alertdialog.findViewById(R.id.txt_alerttitle)
        txttitle.text = title
        val txtmessage :TextView= alertdialog.findViewById(R.id.txt_alertmessage)
        txtmessage.text = message

        val btncanle:ButtonOutline = alertdialog.findViewById(R.id.btn_cancle)
        btncanle.setOnClickListener {
            alertdialog.dismiss()
        }

        alertdialog.show()
        return alertdialog
    }


    fun SuccessDialog(context: Context, title: String, message: String): Dialog {
        val alertdialog = Dialog(context)
        alertdialog.setContentView(R.layout.success_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val txttitle:TextView = alertdialog.findViewById(R.id.txt_alerttitle)
        txttitle.text = title
        val txtmessage:TextView = alertdialog.findViewById(R.id.txt_alertmessage)
        txtmessage.text = message
        alertdialog.show()
        return alertdialog
    }

    fun NoInternetDialog(context: Context): Dialog {
        val alertdialog = Dialog(context)
        alertdialog.setContentView(R.layout.nointernet_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        alertdialog.show()
        return alertdialog
    }

}