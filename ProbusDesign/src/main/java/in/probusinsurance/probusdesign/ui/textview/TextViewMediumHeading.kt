package `in`.probusinsurance.probusdesign.ui.textview

import `in`.probusinsurance.probusdesign.R
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet

@SuppressLint("NewApi")
class TextViewMediumHeading(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {
        init {

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
                this.setTextAppearance(R.style.TextView_HeadingMedium_Style)
                val customAttributesStyle =
                    context.obtainStyledAttributes(attrs, R.styleable.TextViewMediumHeading, 0, 0)

                try {

                    var colorEnable = customAttributesStyle.getBoolean(
                        R.styleable.TextViewMediumHeading_customColorEnable,
                        false
                    )

                    if (colorEnable) {
                        this.setTextColor(
                            customAttributesStyle.getColor(
                                R.styleable.TextViewMediumHeading_customColor,
                                resources.getColor(R.color.text_Color_SubHeading_Large)
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