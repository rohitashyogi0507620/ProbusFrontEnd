package `in`.probusinsurance.probusdesign.ui.checkbox

import `in`.probusinsurance.probusdesign.R
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet

@SuppressLint("NewApi")
class SingleCheckBox(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatCheckBox(
        context!!, attrs
    ) {
    init {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            this.setTextAppearance(R.style.CheckBox_Single_Style)

        }
    }
}