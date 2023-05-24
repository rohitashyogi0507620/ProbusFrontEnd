package `in`.probusinsurance.probusdesign.ui.edittext;

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.os.Build
import android.util.AttributeSet


class EmailEditText(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatEditText(
        context!!, attrs
    ) {
    init {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            this.setTextAppearance(context, R.style.EditText_Style_Normal)
        }

    }

}
