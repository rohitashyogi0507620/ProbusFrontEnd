package `in`.probusinsurance.probusdesign.UI.TextView
import `in`.probusinsurance.probusdesign.R
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet

@SuppressLint("NewApi")
class TextViewSubHeadingLight(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {
        init {
            this.setTextAppearance(R.style.TextView_SubHeadingLight_Style)

            val customAttributesStyle = context.obtainStyledAttributes(attrs, R.styleable.TextViewSubHeadingLight, 0, 0)

            try {

                val colorEnable = customAttributesStyle.getBoolean(
                    R.styleable.TextViewSubHeadingLight_customColorEnable,
                    false
                )

                if (colorEnable) {
                    this.setTextColor(
                        customAttributesStyle.getColor(
                            R.styleable.TextViewSubHeadingLight_customColor,
                            resources.getColor(R.color.text_Color_SubHeading_Small,null)
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