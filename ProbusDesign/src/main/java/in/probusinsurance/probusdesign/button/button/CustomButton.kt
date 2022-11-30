package `in`.probusinsurance.probusdesign.button.button

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.widget.Button

class CustomButton(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatImageView(context, attrs) {
    init {
        this.setImageDrawable(resources.getDrawable(R.drawable.ic_back))
        this.isClickable = true
    }

    override fun dispatchSetPressed(pressed: Boolean) {
        super.dispatchSetPressed(pressed)
        if(getDrawable() == null)
            return;

        if(pressed) {
            getDrawable().setColorFilter(0x44000000, PorterDuff.Mode.SRC_ATOP);
            invalidate();
        }
        else {
            getDrawable().clearColorFilter();
            invalidate();
        }
    }
}