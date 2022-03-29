package `in`.probusinsurance.ProbusFrontEnd

import `in`.probusinsurance.probusdesign.ModelClass.MasterEntity
import `in`.probusinsurance.probusdesign.ModelClass.SpinnerItemMasterEntryAdapter
import `in`.probusinsurance.probusdesign.ProbusDesign
import `in`.probusinsurance.probusdesign.UI.AutoComplete.AutoComplete
import `in`.probusinsurance.probusdesign.UI.Button.ButtonRound
import `in`.probusinsurance.probusdesign.UI.Spinner.Spinner
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnstartmodule = findViewById<Button>(R.id.button_startmodule)
        val buttonRound = findViewById<ButtonRound>(R.id.btnround)

        buttonRound.setOnClickListener {
            if (buttonRound.isactive) {
                buttonRound.setButtonIsactive(false)
            } else {
                buttonRound.setButtonIsactive(true)
            }
        }
        btnstartmodule.setOnClickListener {
            fun_startmodule()
        }

        var spinner = findViewById<Spinner>(R.id.spinner)
        var autocomplete = findViewById<AutoComplete>(R.id.autocomplete_text)
        var list = arrayListOf<MasterEntity>()
        list.add(MasterEntity("12 th Pass", "12 th Pass"))
        list.add(MasterEntity("10 th Pass", "10 th Pass"))
        list.add(MasterEntity("Graduation", "Graduation"))
        list.add(MasterEntity("Post Graduation", "Post Graduation"))
        spinner.setSpinner(this, list)


        val adapter = SpinnerItemMasterEntryAdapter(this, `in`.probusinsurance.probusdesign.R.layout.spinner_item, `in`.probusinsurance.probusdesign.R.id.item_text, list)
        autocomplete.setAdapter(adapter)
        autocomplete.setOnTouchListener(OnTouchListener { v, event ->
            if (MotionEvent.ACTION_UP == event.action) {
                autocomplete.showDropDown()
            }
            false
        })
        autocomplete.setOnItemClickListener(OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(
                applicationContext,
                autocomplete.getText().toString(),
                Toast.LENGTH_SHORT
            ).show()
        })

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