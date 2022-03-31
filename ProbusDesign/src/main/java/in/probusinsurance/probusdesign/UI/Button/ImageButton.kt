package `in`.probusinsurance.probusdesign.UI.Button

import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet

class ImageButton(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatImageView(context, attrs) {
    init {
        this.isClickable = true
    }

    override fun dispatchSetPressed(pressed: Boolean) {
        super.dispatchSetPressed(pressed)
        if (getDrawable() == null)
            return;

        if (pressed) {
            getDrawable().setColorFilter(0x44000000, PorterDuff.Mode.SRC_ATOP);
            invalidate();
        } else {
            getDrawable().clearColorFilter();
            invalidate();
        }
    }
}