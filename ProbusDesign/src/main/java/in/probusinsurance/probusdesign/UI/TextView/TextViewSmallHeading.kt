package `in`.probusinsurance.probusdesign.UI.TextView

import `in`.probusinsurance.probusdesign.R
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

@SuppressLint("NewApi")
class TextViewSmallHeading(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {
        init {
            this.setTextAppearance(R.style.TextView_HeadingSmall_Style)
        }
}