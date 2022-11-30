package `in`.probusinsurance.probusfrontend

import `in`.probusinsurance.probusdesign.MasterEntity
import `in`.probusinsurance.probusdesign.ui.dialog.AlertDialog
import `in`.probusinsurance.probusdesign.ui.HeadingWithCustomChipLayout
import `in`.probusinsurance.probusdesign.ui.HeadingWithFixChipLayout
import `in`.probusinsurance.probusdesign.ui.layout.ProgessLayout
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer


class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var yesnolayout = findViewById<HeadingWithFixChipLayout>(R.id.layout_yesno)
        var whatsapp = findViewById<HeadingWithFixChipLayout>(R.id.whatsapp)
        yesnolayout.ischecked.observe(this, Observer {
            Toast.makeText(
                applicationContext,
                "${it.toString()} + ${yesnolayout.title()}",
                Toast.LENGTH_SHORT
            ).show()
        })


        whatsapp.ischecked.observe(this, Observer {
            Toast.makeText(
                applicationContext,
                "${it.toString()} + ${whatsapp.title()}",
                Toast.LENGTH_SHORT
            ).show()
        })

        var customlayout = findViewById<HeadingWithCustomChipLayout>(R.id.layout_city)
        // customlayout.setChipItems(this, resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.array_resistrationyear))
        //customlayout.setChipItems(this, resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.IdArray_City), resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.NameArray_City))
        //customlayout.autoFillById("2020")
        //customlayout.autoFillById("AJ")
        var data =
            resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.NameArray_City)
        var datalist: MutableList<MasterEntity>
        datalist = mutableListOf()
        data.forEachIndexed { index, s ->
            datalist.add(MasterEntity(index.toString(), s))

        }
        customlayout.setChipItems(this, datalist)
        customlayout.autoFillByMaster(MasterEntity("JAI", "Jaipur"))
        customlayout.selectedItem.observe(this, Observer {
            Toast.makeText(applicationContext, "${it.Name} + ${it.Id}", Toast.LENGTH_SHORT).show()
        })

        var parentlayout = findViewById<RelativeLayout>(R.id.relative_layout)

        var progessLayout = findViewById<ProgessLayout>(R.id.layout_progess)
     //   progessLayout.setEnableControls(false, progessLayout)

        // progessLayout.enableControl(true, parentlayout)
        //  progessLayout.setanimationFile(R.raw.progess_2)
//        var progessLayout=ProgessLayout(applicationContext,null)
//        parentlayout.addView(progessLayout)
//        disableEnableControls(false,parentlayout)

        //startActivity(Intent(applicationContext,FragmentActivity::class.java))
    }

    private fun disableEnableControls(enable: Boolean, vg: ViewGroup) {

        for (i in 0 until vg.childCount) {
            val child = vg.getChildAt(i)
            child.isEnabled = enable
            child.isClickable = enable
            if (child is ViewGroup) {
                disableEnableControls(enable, child)
            }
        }

    }

    fun info_dialog(view: View) {
        AlertDialog.InfoDialog(
            this,
            "Your Vehicle RJ-14-QS-7194 is already in inspection mode",
            "Try Again"
        )
            .show()

    }

    fun error_dialog(view: View) {
        AlertDialog.ErrorDialog(
            this,
            "Error while proposal",
            "Your Vehicle RJ-14-QS-7194 is already in inspection mode",
            "Ok"
        )
            .show()

    }

    fun exit_dialog(view: View) {
//        AlertDialog.ExitDialog(
//            this,
//            "Do you want to exit ?",
//            "Your Vehicle RJ-14-QS-7194 is already in inspection mode"
//        ).show()
        AlertDialog.ExitDialog(this).show()

    }

    fun success_dialog(view: View) {
//        AlertDialog.SuccessDialog(
//            this,
//            "Thank You",
//            "Policy is done for your vehicle RJ-14-QS-7845 .Your Policy start from 24-Jun-2022 to 25-jun-2024 with pa covered"
//        ).show()

        val alertdialog = AlertDialog.SuccessDialog(
            this,
            "Thank You !",
            "Your Forward Payment request has been sent successfully. Your Quotation Number is : "
        )
        val btn = alertdialog.findViewById<Button>(`in`.probusinsurance.probusdesign.R.id.btn_ok)
        btn.text = "Ok"
        btn.setOnClickListener { view: View? ->

        }
    }

    fun nointernet_dialog(view: View) {
        AlertDialog.NoInternetDialog(this).show()
    }
}