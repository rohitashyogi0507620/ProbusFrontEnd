package `in`.probusinsurance.probusdesign.UI.AutoComplete

import `in`.probusinsurance.probusdesign.ModelClass.MasterEntity
import `in`.probusinsurance.probusdesign.ModelClass.SpinnerItemMasterEntryAdapter
import `in`.probusinsurance.probusdesign.R
import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter

class AutoComplete(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatAutoCompleteTextView(context, attrs) {

    init {
        this.maxLines = 1
        this.isSingleLine = true
        this.setThreshold(1)
    }
}


