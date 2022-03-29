package `in`.probusinsurance.probusdesign.UI.Spinner

import `in`.probusinsurance.probusdesign.ModelClass.MasterEntity
import `in`.probusinsurance.probusdesign.ModelClass.SpinnerItemMasterEntryAdapter
import `in`.probusinsurance.probusdesign.R
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import android.widget.Spinner

class Spinner(context: Context?, attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatSpinner(
    context!!, attrs
) {

    var selectedItem: MasterEntity
    var itemposition: Int
    var list_Item: List<MasterEntity>


    init {

        list_Item = arrayListOf()
        this.setBackgroundDrawable(resources.getDrawable(R.drawable.background_spinner))
        selectedItem = MasterEntity("", "")
        itemposition = 0;


    }

    fun setSpinner(context: Activity, list: List<MasterEntity>) {
        list_Item = list
        val spinner = SpinnerItemMasterEntryAdapter(context, R.layout.spinner_item, R.id.item_text, list)
        this.setAdapter(spinner)
        this.setOnItemSelectedListener(
            object : OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View,
                    i: Int,
                    l: Long
                ) {
                    selectedItem = list_Item.get(i)
                    itemposition = i
                }

                override fun onNothingSelected(adapterView: AdapterView<*>?) {}
            })

    }

    fun getSpinnerSelectedItem(): MasterEntity {
        return selectedItem
    }

    fun getSpinnerPosition(): Int {
        return itemposition
    }
}