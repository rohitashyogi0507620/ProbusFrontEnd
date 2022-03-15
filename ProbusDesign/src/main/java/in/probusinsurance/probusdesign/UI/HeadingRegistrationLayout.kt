package `in`.probusinsurance.probusdesign.UI

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class HeadingRegistrationLayout(context: Context, attrs: AttributeSet) :

    LinearLayout(context, attrs) {

    init {

        inflate(context, R.layout.heading_registration_layout, this)

        val customAttributesStyle = context.obtainStyledAttributes(attrs, R.styleable.HeadingRegistrationLayout, 0, 0)
        val heading = findViewById<TextView>(R.id.txt_heading)
        val subheading = findViewById<TextView>(R.id.txt_subheading)

        try {

            heading.text = customAttributesStyle.getText(R.styleable.HeadingRegistrationLayout_headingtext)
            subheading.text = customAttributesStyle.getString(R.styleable.HeadingRegistrationLayout_subheadingtext)


        } finally {
            customAttributesStyle.recycle()
        }

//        button1.setOnClickListener {
//            // Handle button1 click event...
//        }
//
//        button2.setOnClickListener {
//            // Handle button2 click event...
//        }
        invalidate()
        requestLayout()
    }
}