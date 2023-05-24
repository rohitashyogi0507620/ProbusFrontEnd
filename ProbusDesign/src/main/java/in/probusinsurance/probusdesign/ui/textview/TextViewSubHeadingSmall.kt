package `in`.probusinsurance.probusdesign.ui.textview

import `in`.probusinsurance.probusdesign.R
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet

@SuppressLint("NewApi")
class TextViewSubHeadingSmall(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {
    init {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            this.setTextAppearance(R.style.TextView_SubHeadingSmall_Style)
            val customAttributesStyle =
                context.obtainStyledAttributes(attrs, R.styleable.TextViewSubHeadingSmall, 0, 0)

            try {

                var colorEnable = customAttributesStyle.getBoolean(
                    R.styleable.TextViewSubHeadingSmall_customColorEnable,
                    false
                )

                if (colorEnable) {
                    this.setTextColor(
                        customAttributesStyle.getColor(
                            R.styleable.TextViewSubHeadingSmall_customColor,
                            resources.getColor(R.color.text_Color_SubHeading_Small)
                        )
                    )
                }


            } finally {
                customAttributesStyle.recycle()
            }
        }

        invalidate()
        requestLayout()


    }
}