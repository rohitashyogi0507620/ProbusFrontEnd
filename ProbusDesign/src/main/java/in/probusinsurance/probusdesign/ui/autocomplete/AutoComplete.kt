package `in`.probusinsurance.probusdesign.ui.autocomplete

import `in`.probusinsurance.probusdesign.MasterEntity
import `in`.probusinsurance.probusdesign.R
import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class AutoComplete(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatAutoCompleteTextView(context, attrs) {

    private var _selectedItem = MutableLiveData<MasterEntity>()
    val selectedItem: LiveData<MasterEntity>
        get() = _selectedItem
    private var _itemposition = MutableLiveData<Int>()
    val itemposition: LiveData<Int>
        get() = _itemposition

    var list_Item: List<MasterEntity>

    init {
        list_Item = arrayListOf()
        this.maxLines = 1
        this.isSingleLine = true
        this.setThreshold(1)
        this.setOnTouchListener(OnTouchListener { v, event ->
            if (MotionEvent.ACTION_UP == event.action) {
                this.showDropDown()
            }
            false
        })
        this.setOnItemClickListener(OnItemClickListener { adapterView, view, i, l ->
            _selectedItem.postValue(adapterView.adapter.getItem(i) as MasterEntity)
            _itemposition.postValue(i)
            this.setSelection(this.text.length)
            this.error=null
        })


    }

    fun setAutoComplete(context: Activity, list: List<MasterEntity>) {
        list_Item = list
        this.setAdapter<ArrayAdapter<MasterEntity>>(
            ArrayAdapter<MasterEntity>(
                context,
                R.layout.autocompleted_item,
                list_Item
            )
        )

    }

    fun setAutoComplete(context: Activity, listId: Array<String>) {

        var listitem = mutableListOf<MasterEntity>()
        for (i in listId.indices) {
            listitem.add(MasterEntity(listId[i], listId[i]))
        }

        list_Item = listitem
        this.setAdapter<ArrayAdapter<MasterEntity>>(
            ArrayAdapter<MasterEntity>(
                context,
                R.layout.autocompleted_item,
                list_Item
            )
        )


    }

    fun setAutoComplete(context: Activity, listId: Array<String>, listname: Array<String>) {

        var listitem = mutableListOf<MasterEntity>()
        for (i in listId.indices) {
            listitem.add(MasterEntity(listId[i], listname[i]))
        }

        list_Item = listitem
        this.setAdapter<ArrayAdapter<MasterEntity>>(
            ArrayAdapter<MasterEntity>(
                context,
                R.layout.autocompleted_item,
                list_Item
            )
        )

    }


    fun autoFillById(id: String) {

        if (list_Item != null) {
            for (i in list_Item.indices) {
                if (list_Item.get(i).Id.equals(id)) {
                    _selectedItem.value = list_Item.get(i)
                    this.setText(list_Item.get(i).Name)
                    break;
                }
            }
        }
    }

    fun autoFillByName(name: String) {

        if (list_Item != null) {
            for (i in list_Item.indices) {
                if (list_Item.get(i).Name.equals(name)) {
                    _selectedItem.value = list_Item.get(i)
                    this.setText(list_Item.get(i).Name)
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
                    _selectedItem.value = list_Item.get(i)
                    this.setText(list_Item.get(i).Name)
                    break;
                }
            }
        }
    }

    fun getAutoCompleteSelectedItem(): MasterEntity {
        return _selectedItem.value!!
    }

    fun getAutoCompletePosition(): Int {
        return _itemposition.value!!
    }
}


