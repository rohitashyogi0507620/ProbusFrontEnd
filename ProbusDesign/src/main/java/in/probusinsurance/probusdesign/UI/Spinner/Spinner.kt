package `in`.probusinsurance.probusdesign.UI.Spinner

import `in`.probusinsurance.probusdesign.MasterEntity
import `in`.probusinsurance.probusdesign.ModelClass.SpinnerItemMasterEntryAdapter
import `in`.probusinsurance.probusdesign.R
import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class Spinner(context: Context?, attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatSpinner(
    context!!, attrs
) {

    private var _selectedItem = MutableLiveData<MasterEntity>()
    val selectedItem: LiveData<MasterEntity>
        get() = _selectedItem

    private var _itemposition = MutableLiveData<Int>()
    val itemposition: LiveData<Int>
        get() = _itemposition

    var list_Item: List<MasterEntity>


    init {

        list_Item = arrayListOf()
        this.setBackgroundDrawable(resources.getDrawable(R.drawable.background_spinner))
        this.setOnItemSelectedListener(
            object : OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View,
                    i: Int,
                    l: Long
                ) {
                    _selectedItem.postValue(list_Item.get(i))
                    _itemposition.postValue(i)

                }

                override fun onNothingSelected(adapterView: AdapterView<*>?) {}
            })


    }

    fun setSpinner(context: Activity, list: List<MasterEntity>) {
        list_Item = list
        val spinner = SpinnerItemMasterEntryAdapter(context, R.layout.spinner_item, R.id.item_text, list)
        this.setAdapter(spinner)

    }

    fun setSpinner(context: Activity, listId: Array<String>) {

        var listitem = mutableListOf<MasterEntity>()
        for (i in listId.indices) {
            listitem.add(MasterEntity(listId[i], listId[i]))
        }

        list_Item = listitem
        val spinner = SpinnerItemMasterEntryAdapter(context, R.layout.spinner_item, R.id.item_text, list_Item)
        this.setAdapter(spinner)

    }

    fun setSpinner(context: Activity, listId: Array<String>, listname: Array<String>) {

        var listitem = mutableListOf<MasterEntity>()
        for (i in listId.indices) {
            listitem.add(MasterEntity(listId[i], listname[i]))
        }
        list_Item = listitem
        val spinner =
            SpinnerItemMasterEntryAdapter(context, R.layout.spinner_item, R.id.item_text, list_Item)
        this.setAdapter(spinner)
    }


    fun autoFillById(id: String) {

        if (list_Item != null) {
            for (i in list_Item.indices) {
                if (list_Item.get(i).Id.equals(id)) {
                    this.setSelection(i);
                    break;
                }
            }
        }
    }

    fun autoFillByName(name: String) {

        if (list_Item != null) {
            for (i in list_Item.indices) {
                if (list_Item.get(i).Name.equals(name)) {
                    this.setSelection(i);
                    break;
                }
            }
        }
    }

    fun autoFillByMaster(item: MasterEntity) {
        if (list_Item != null) {
            for (i in list_Item.indices) {
                if (list_Item.get(i).Id.equals(item.Id) &&
                    list_Item.get(i).Name.equals(item.Name)
                ) {
                    this.setSelection(i);
                    break;
                }
            }
        }
    }

    fun setError(errormesage: String) {

        val errorText = this.getSelectedView() as TextView
        errorText.error = ""
        errorText.setTextColor(context.resources.getColor(R.color.color_inputlayout_error)) //just to highlight that this is an error
        errorText.text = errormesage


    }

    fun getSpinnerSelectedItem(): MasterEntity {
        return _selectedItem.value!!
    }

    fun getSpinnerPosition(): Int {
        return _itemposition.value!!
    }

}
