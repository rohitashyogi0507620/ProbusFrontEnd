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
import android.widget.Toast

class AutoComplete(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatAutoCompleteTextView(context, attrs) {

    var selectedItem: MasterEntity
    var itemposition: Int

    init {
        this.maxLines = 1
        this.isSingleLine = true
        this.setThreshold(1)
        this.setOnTouchListener(OnTouchListener { v, event ->
            if (MotionEvent.ACTION_UP == event.action) {
                this.showDropDown()
            }
            false
        })
        selectedItem = MasterEntity("", "")
        itemposition = 0;
    }

    fun setAutoComplete(context: Activity, list: List<MasterEntity>){
        this.setAdapter<ArrayAdapter<MasterEntity>>(
            ArrayAdapter<MasterEntity>(
                context,
                R.layout.autocompleted_item,
                list
            )
        )
        this.setOnItemClickListener(OnItemClickListener { adapterView, view, i, l ->
            selectedItem= adapterView.adapter.getItem(i) as MasterEntity
            itemposition = i
        })

    }

    fun getAutoCompleteSelectedItem(): MasterEntity {
        return selectedItem
    }

    fun getAutoCompletePosition(): Int {
        return itemposition
    }
}


