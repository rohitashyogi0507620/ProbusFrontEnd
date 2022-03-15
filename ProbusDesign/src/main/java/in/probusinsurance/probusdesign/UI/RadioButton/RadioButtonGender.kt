package `in`.probusinsurance.probusdesign.UI.RadioButton

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.util.AttributeSet
import android.widget.RadioButton

class RadioButtonGender(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatRadioButton(context, attrs) {
        init {
            this.setTextAppearance(context,R.style.RadioButton_Gender_Style)

        }
}