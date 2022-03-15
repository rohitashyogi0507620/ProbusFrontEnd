package `in`.probusinsurance.ProbusFrontEnd

import `in`.probusinsurance.probusdesign.ProbusDesign
import `in`.probusinsurance.probusdesign.UI.Button.ButtonRound
import `in`.probusinsurance.probusdesign.UI.EditText.EditTextInput
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

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

//        var textlayout=findViewById<EditTextInput>(R.id.editext_inputlayout)
//        textlayout.setErrorLayout(true,"Please enter valid email id",resources.getDrawable(`in`.probusinsurance.probusdesign.R.drawable.ic_password_missmatch))
//        textlayout.setErrorText("Chal n apna kam kr na")
//        textlayout.setErrorTextColor(R.color.radiobutton_textcolor)

    }

    fun fun_startmodule() {
        ProbusDesign.StartDesignActivity(applicationContext)
    }
}