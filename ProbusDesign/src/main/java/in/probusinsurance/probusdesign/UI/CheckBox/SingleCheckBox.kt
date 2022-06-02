package `in`.probusinsurance.probusdesign.UI.CheckBox

import `in`.probusinsurance.probusdesign.R
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import androidx.core.view.marginTop

@SuppressLint("NewApi")
class SingleCheckBox(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatCheckBox(
        context!!, attrs
    ) {
    init {
        this.setTextAppearance(R.style.CheckBox_Single_Style)

    }
}