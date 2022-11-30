package `in`.probusinsurance.probusdesign.ui.radiobutton

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.util.AttributeSet

class RadioButtonGender(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatRadioButton(context, attrs) {
        init {
            this.setTextAppearance(context,R.style.RadioButton_Gender_Style)

        }
}