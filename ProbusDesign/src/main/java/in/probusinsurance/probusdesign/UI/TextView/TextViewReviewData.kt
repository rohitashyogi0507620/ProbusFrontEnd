package `in`.probusinsurance.probusdesign.UI.TextView

import `in`.probusinsurance.probusdesign.R
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet

@SuppressLint("NewApi")
class TextViewReviewData(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {
    init {
        this.setTextAppearance(R.style.TextView_ReviewHeadingData_Style)
        val customAttributesStyle =
            context.obtainStyledAttributes(attrs, R.styleable.TextViewReviewData, 0, 0)

        try {

            var colorEnable = customAttributesStyle.getBoolean(
                R.styleable.TextViewReviewData_customColorEnable,
                false
            )

            if (colorEnable) {
                this.setTextColor(
                    customAttributesStyle.getColor(
                        R.styleable.TextViewReviewData_customColor,
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