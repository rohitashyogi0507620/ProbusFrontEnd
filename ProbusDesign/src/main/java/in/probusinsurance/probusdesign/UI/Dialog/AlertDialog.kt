package `in`.probusinsurance.probusdesign.UI.Dialog

import `in`.probusinsurance.probusdesign.R
import `in`.probusinsurance.probusdesign.UI.Button.ButtonOutline
import `in`.probusinsurance.probusdesign.UI.Button.ButtonRound
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
        alertdialog.setContentView(R.layout.alert_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val txtmessage = alertdialog.findViewById<TextView>(R.id.txt_alerttitle)
        txtmessage.text = message
        return alertdialog
    }

    fun ErrorDialog(context: Context, message: String, btntext: String): Dialog {
        val alertdialog = Dialog(context)
        alertdialog.setContentView(R.layout.alert_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val txtmessage = alertdialog.findViewById<TextView>(R.id.txt_alerttitle)
        val btn = alertdialog.findViewById<ButtonRound>(R.id.btn_ok)
        btn.setText(btntext)
        txtmessage.text = message
        return alertdialog
    }

    fun ErrorDialog(
        context: Context?,
        title: String?,
        message: String?,
        btntext: String
    ): Dialog {
        val alertdialog = Dialog(context!!)
        alertdialog.setContentView(R.layout.alert_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val txtmessage = alertdialog.findViewById<TextView>(R.id.txt_alertmessage)
        txtmessage.visibility = View.VISIBLE
        txtmessage.text = message
        val txttitle = alertdialog.findViewById<TextView>(R.id.txt_alerttitle)
        txttitle.text = title
        return alertdialog
    }

    fun ExitDialog(context: Context?): Dialog {
        val alertdialog = Dialog(context!!)
        alertdialog.setContentView(R.layout.alert_cancle_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val btncanle = alertdialog.findViewById<ButtonOutline>(R.id.btn_cancle)
        btncanle.setOnClickListener {
            alertdialog.dismiss()
        }
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
        val txtmessage = alertdialog.findViewById<TextView>(R.id.txt_alerttitle)
        txtmessage.text = message
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
        val txtmessage = alertdialog.findViewById<TextView>(R.id.txt_alerttitle)
        val btn = alertdialog.findViewById<ButtonRound>(R.id.btn_ok)
        btn.setText(btntext)
        txtmessage.text = message
        return alertdialog
    }

    fun InfoDialog(
        context: Context?,
        title: String?,
        message: String?,
        btntext: String
    ): Dialog {
        val alertdialog = Dialog(context!!)
        alertdialog.setContentView(R.layout.info_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val txtmessage = alertdialog.findViewById<TextView>(R.id.txt_alertmessage)
        txtmessage.visibility = View.VISIBLE
        txtmessage.text = message
        val txttitle = alertdialog.findViewById<TextView>(R.id.txt_alerttitle)
        txttitle.text = title
        val btn = alertdialog.findViewById<ButtonRound>(R.id.btn_ok)
        btn.setText(btntext)
        return alertdialog
    }

    //Edit Dialog
    fun ExitDialog(context: Context?, title: String?, message: String?): Dialog {
        val alertdialog = Dialog(context!!)
        alertdialog.setContentView(R.layout.alert_cancle_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val btncanle = alertdialog.findViewById<ButtonOutline>(R.id.btn_cancle)
        btncanle.setOnClickListener {
            alertdialog.dismiss()
        }
        val txttitle = alertdialog.findViewById<TextView>(R.id.txt_alerttitle)
        txttitle.text = title
        val txtmessage = alertdialog.findViewById<TextView>(R.id.txt_alertmessage)
        txtmessage.text = message

        return alertdialog
    }

    //Sucess  Dialog

    fun SuccessDialog(context: Context?, title: String?, message: String?): Dialog {
        val alertdialog = Dialog(context!!)
        alertdialog.setContentView(R.layout.success_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        val txttitle = alertdialog.findViewById<TextView>(R.id.txt_alerttitle)
        txttitle.text = title
        val txtmessage = alertdialog.findViewById<TextView>(R.id.txt_alertmessage)
        txtmessage.text = message
        return alertdialog
    }

    fun NoInternetDialog(context: Context?): Dialog {
        val alertdialog = Dialog(context!!)
        alertdialog.setContentView(R.layout.nointernet_dialog)
        alertdialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog.setCanceledOnTouchOutside(false)
        alertdialog.window!!.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.FILL_PARENT
        )
        return alertdialog
    }

}