package `in`.probusinsurance.probusdesign.UI.Button

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.util.AttributeSet


class ButtonRound(context: Context, attrs: AttributeSet?) :
    com.google.android.material.button.MaterialButton(context, attrs) {

    var isactive=false
    init {

        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.ButtonRound, 0, 0)

        try {

            isactive = a.getBoolean(R.styleable.ButtonRound_isactive, false)
            setButtonIsactive(isactive)

        } finally {
            a.recycle()
        }
    }


    fun setButtonIsactive(isactive: Boolean) {

        if (isactive) {
            this.isactive =true
            this.isEnabled=true
            this.setBackgroundColor(resources.getColor(R.color.button_Color_Background_Active))
            this.setTextColor(resources.getColor(R.color.button_Color_TextActive))

        } else {
            this.isactive =false
            this.isEnabled=false
            this.setBackgroundColor(resources.getColor(R.color.button_Color_Background_Inactive))
            this.setTextColor(resources.getColor(R.color.button_Color_TextInactive))
        }
        invalidate()
        requestLayout()
    }


}