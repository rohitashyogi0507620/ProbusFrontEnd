package `in`.probusinsurance.probusdesign.ui.switchbutton

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.os.Build
import android.util.AttributeSet

class SwitchButton(context: Context, attrs: AttributeSet?) : androidx.appcompat.widget.SwitchCompat(context, attrs) {

    init {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            this.setTextAppearance(context, R.style.RadioButton_Gender_Style)
        }
    }
}