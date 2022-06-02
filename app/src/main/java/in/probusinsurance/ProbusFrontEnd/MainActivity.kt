package `in`.probusinsurance.ProbusFrontEnd

import `in`.probusinsurance.probusdesign.ModelClass.MasterEntity
import `in`.probusinsurance.probusdesign.ProbusDesign
import `in`.probusinsurance.probusdesign.UI.AutoComplete.AutoComplete
import `in`.probusinsurance.probusdesign.UI.Button.ButtonRound
import `in`.probusinsurance.probusdesign.UI.EditText.EditTextInput
import `in`.probusinsurance.probusdesign.UI.Spinner.Spinner
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

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

            params.leftMargin = 20
            params.rightMargin = 20
            params.topMargin = 10
            params.bottomMargin = 10
            ll_checkbox.addView(mChip, params)
        }

        var spinner = findViewById<Spinner>(R.id.spinner)
        var list = arrayListOf<MasterEntity>()
        list.add(MasterEntity("Select Education *", "Select Education *"))
        list.add(MasterEntity("12", "12 th Pass"))
        list.add(MasterEntity("10", "10 th Pass"))
        list.add(MasterEntity("15", "Graduation"))
        list.add(MasterEntity("18 ", "Post Graduation"))
        spinner.setSpinner(this, list)

        var autocomplete = findViewById<AutoComplete>(R.id.autocomplete_text)
        autocomplete.setAutoComplete(this, list)


        buttonRound.setOnClickListener {

            selected = autocomplete.getAutoCompleteSelectedItem()
            selectedSpinner = spinner.getSpinnerSelectedItem()

            Toast.makeText(applicationContext,
            selected.Name+" : "+selected.Id,
            Toast.LENGTH_SHORT
            ).show()

            Toast.makeText(applicationContext,
                selectedSpinner.Name+" : "+selectedSpinner.Id,
            Toast.LENGTH_SHORT
            ).show()

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


//        val adapter = SpinnerItemMasterEntryAdapter(
//            this,
//            `in`.probusinsurance.probusdesign.R.layout.spinner_item,
//            `in`.probusinsurance.probusdesign.R.id.item_text,
//            list
//        )
//        autocomplete.setAdapter(adapter)
//        autocomplete.setOnTouchListener(OnTouchListener { v, event ->
//            if (MotionEvent.ACTION_UP == event.action) {
//                autocomplete.showDropDown()
//            }
//            false
//        })


//        var textlayout=findViewById<EditTextInput>(R.id.editext_inputlayout)
//        textlayout.setErrorLayout(true,"Please enter valid email id",resources.getDrawable(`in`.probusinsurance.probusdesign.R.drawable.ic_password_missmatch))
//        textlayout.setErrorText("Chal n apna kam kr na")
//        textlayout.setErrorTextColor(R.color.radiobutton_textcolor)

        Toast.makeText(this, spinner.selectedItem.Name, Toast.LENGTH_SHORT).show()

    }

    fun fun_startmodule() {
        ProbusDesign.StartDesignActivity(applicationContext)
    }

}