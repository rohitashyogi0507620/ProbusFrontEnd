package `in`.probusinsurance.probusdesign.UI.EditText;

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.util.AttributeSet


class EmailEditText(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatEditText(
        context!!, attrs
    ) {
    init {
        this.setTextAppearance(context, R.style.EditText_Style_Normal)

    }

}
