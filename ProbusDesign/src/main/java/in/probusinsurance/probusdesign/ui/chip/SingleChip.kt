package `in`.probusinsurance.probusdesign.ui.chip

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import com.google.android.material.chip.Chip

class SingleChip(context: Context?, attrs: AttributeSet?) :
    Chip(context, attrs) {
    init {
         this.setTextAppearance(R.style.Chip_Single_Style)
         val paddingDp = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 20f,
            resources.displayMetrics
        ).toInt()
        this.setPadding(paddingDp, paddingDp, paddingDp, paddingDp)
    }
}