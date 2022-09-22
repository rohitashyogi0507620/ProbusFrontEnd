package `in`.probusinsurance.probusdesign.UI.TextView

import `in`.probusinsurance.probusdesign.R
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

@SuppressLint("NewApi")
class TextViewSubHeadingLarge(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {
        init {
            this.setTextAppearance(R.style.TextView_SubHeadingLarge_Style)
            val customAttributesStyle = context.obtainStyledAttributes(attrs, R.styleable.TextViewSubHeadingLarge, 0, 0)

            try {

                var colorEnable = customAttributesStyle.getBoolean(
                    R.styleable.TextViewSubHeadingLarge_customColorEnable,
                    false
                )

                if (colorEnable) {
                    this.setTextColor(
                        customAttributesStyle.getColor(
                            R.styleable.TextViewSubHeadingLarge_customColor,
                            resources.getColor(R.color.text_Color_SubHeading_Large)
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