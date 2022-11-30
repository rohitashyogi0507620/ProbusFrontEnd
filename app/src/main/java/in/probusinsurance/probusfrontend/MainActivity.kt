package `in`.probusinsurance.probusfrontend

import `in`.probusinsurance.probusdesign.MasterEntity
import `in`.probusinsurance.probusdesign.ProbusDesign
import `in`.probusinsurance.probusdesign.ui.autocomplete.AutoComplete
import `in`.probusinsurance.probusdesign.ui.button.ButtonRound
import `in`.probusinsurance.probusdesign.ui.edittext.EditTextInput
import `in`.probusinsurance.probusdesign.ui.spinner.Spinner
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity(){

    lateinit var ll_checkbox: LinearLayout
    lateinit var il_txt: EditTextInput
    lateinit var selected: MasterEntity
    lateinit var selectedSpinner: MasterEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnstartmodule = findViewById<Button>(R.id.button_startmodule)
        val buttonRound = findViewById<ButtonRound>(R.id.btnround)
        ll_checkbox = findViewById(R.id.ll_checkbox)
        il_txt = findViewById(R.id.il_txt)

        var additionalcoverlist = java.util.ArrayList<String>()
        additionalcoverlist.add("Cover against 19 critical illnesses")
        additionalcoverlist.add("Waiver of Premium")
        additionalcoverlist.add("Cover for spouse")
        for (checkbox in additionalcoverlist) {
            var mChip =
                this.layoutInflater.inflate(R.layout.layout_item_checkbox, null, false) as CheckBox
            mChip.text = checkbox
            mChip.id = View.generateViewId()
            //mChip.setOnClickListener(this)
            val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )

            params.leftMargin = 15
            params.rightMargin = 15
            params.topMargin = 0
            params.bottomMargin = 15
            ll_checkbox.addView(mChip)
        }

        //Spinner Work
        var spinner = findViewById<Spinner>(R.id.spinner)
        var list = arrayListOf<MasterEntity>()
        list.add(MasterEntity("Select Education *", "Select Education *"))
        list.add(MasterEntity("12", "12 th Pass"))
        list.add(MasterEntity("10", "10 th Pass"))
        list.add(MasterEntity("15", "Graduation"))
        list.add(MasterEntity("18 ", "Post Graduation"))
        // spinner.setSpinner(this, list)
        // spinner.autoFillByName("Graduation")
        // spinner.autoFillById("10")
        // spinner.autoFillByMaster(MasterEntity("18 ", "Post Graduation"))

        spinner.selectedItem.observe(this, Observer {
            Toast.makeText(
                applicationContext,
                it.Name + " : " + it.Id,
                Toast.LENGTH_SHORT
            ).show()
        })
//        spinner.setSpinner(
//            this,
//            resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.Idarray_yesno),
//            resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.array_yesno)
//        )


        // Auto Complete Work
        var autocomplete = findViewById<AutoComplete>(R.id.autocomplete_text)
        //autocomplete.setAutoComplete(this, list)
        autocomplete.setAutoComplete(
            this,
            resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.Idarray_yesno),
            resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.array_yesno)
        )
        // autocomplete.autoFillByName("Graduation")
        // autocomplete.autoFillById("10")
        // autocomplete.autoFillByMaster(MasterEntity("18 ", "Post Graduation"))

        buttonRound.setOnClickListener {
           // autocomplete.setError("Select ")

//            selected = autocomplete.getAutoCompleteSelectedItem()
//            selectedSpinner = spinner.getSpinnerSelectedItem()
            // spinner.setError("Nhi Bhai ")

//
//            Toast.makeText(
//                applicationContext,
//                selected.Name + " : " + selected.Id,
//                Toast.LENGTH_SHORT
//            ).show()
//
//            Toast.makeText(
//                applicationContext,
//                "Position :" + spinner.getSpinnerPosition() + " ," + selectedSpinner.Name + " : " + selectedSpinner.Id,
//                Toast.LENGTH_SHORT
//            ).show()
           startActivity(Intent(applicationContext, BindingTestActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))

//            if (buttonRound.isactive) {
//                buttonRound.setButtonIsactive(false)
//            } else {
//                buttonRound.setButtonIsactive(true)
//            }


        }


        btnstartmodule.setOnClickListener {
            // fun_startmodule()
            // spinner.setError("Please Select Education*")
        }


//        var textlayout=findViewById<EditTextInput>(R.id.editext_inputlayout)
//        textlayout.setErrorLayout(true,"Please enter valid email id",resources.getDrawable(`in`.probusinsurance.probusdesign.R.drawable.ic_password_missmatch))
//        textlayout.setErrorText("Chal n apna kam kr na")
//        textlayout.setErrorTextColor(R.color.radiobutton_textcolor)

//        binding.ilTxt.setErrorLayout(
//            true,
//            "Enter Email",
//            resources.getDrawable(`in`.probusinsurance.probusdesign.R.drawable.ic_password_missmatch)
//        )

    }

    fun fun_startmodule() {
        ProbusDesign.StartDesignActivity(applicationContext)
    }


}