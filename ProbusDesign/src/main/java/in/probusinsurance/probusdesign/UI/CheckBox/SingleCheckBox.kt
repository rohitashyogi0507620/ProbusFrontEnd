package `in`.probusinsurance.probusdesign.UI.CheckBox

import `in`.probusinsurance.probusdesign.R
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.CheckBox
import androidx.annotation.RequiresApi
import com.google.android.material.chip.Chip

class SingleCheckBox(context: Context?, attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatCheckBox(
    context!!, attrs) {
    init {
        this.setTextAppearance(context,R.style.CheckBox_Single_Style)
          }
}