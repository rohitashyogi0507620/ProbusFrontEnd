package `in`.probusinsurance.probusdesign.ui.textview

import `in`.probusinsurance.probusdesign.R
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet

@SuppressLint("NewApi")
class TextViewLargeHeading(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {
        init {
            this.setTextAppearance(R.style.TextView_HeadingLarge_Style)

            val customAttributesStyle =
                context.obtainStyledAttributes(attrs, R.styleable.TextViewLargeHeading, 0, 0)

            try {

                var colorEnable = customAttributesStyle.getBoolean(
                    R.styleable.TextViewSubHeadingSmall_customColorEnable,
                    false
                )

                if (colorEnable) {
                    this.setTextColor(
                        customAttributesStyle.getColor(
                            R.styleable.TextViewSubHeadingSmall_customColor,
                            resources.getColor(R.color.text_Color_Heading_Large)
                        )
                    )
                }


            } finally {
                customAttributesStyle.recycle()
            }


            invalidate()
            requestLayout()
        }
}