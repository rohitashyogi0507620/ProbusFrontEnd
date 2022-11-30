package `in`.probusinsurance.probusdesign.ui.switchbutton

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.util.AttributeSet

class SwitchButton(context: Context, attrs: AttributeSet?) : androidx.appcompat.widget.SwitchCompat(context, attrs) {

    init {
        this.setTextAppearance(context, R.style.RadioButton_Gender_Style)
    }
}