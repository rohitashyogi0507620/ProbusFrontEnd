package `in`.probusinsurance.probusdesign.ui.chip

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.chip.ChipGroup

class ChipGroupSingleSelection(context: Context?, attrs: AttributeSet?) :
    ChipGroup(context, attrs) {
    init {
        this.isSingleSelection = true
        this.isSelectionRequired = true
    }
}