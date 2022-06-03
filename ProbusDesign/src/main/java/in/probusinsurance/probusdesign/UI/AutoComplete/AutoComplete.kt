package `in`.probusinsurance.probusdesign.UI.AutoComplete

import `in`.probusinsurance.probusdesign.MasterEntity
import `in`.probusinsurance.probusdesign.R
import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter


class AutoComplete(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatAutoCompleteTextView(context, attrs) {

    var selectedItem: MasterEntity
    var itemposition: Int
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
        selectedItem = MasterEntity("", "")
        itemposition = 0;
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
        this.setOnItemClickListener(OnItemClickListener { adapterView, view, i, l ->
            selectedItem = adapterView.adapter.getItem(i) as MasterEntity
            itemposition = i
        })

    }

    fun setAutoComplete(context: Activity, listId: Array<String>) {

        var listitem= mutableListOf<MasterEntity>()
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
        this.setOnItemClickListener(OnItemClickListener { adapterView, view, i, l ->
            selectedItem = adapterView.adapter.getItem(i) as MasterEntity
            itemposition = i
        })

    }

    fun setAutoComplete(context: Activity, listId: Array<String>, listname: Array<String>) {

        var listitem= mutableListOf<MasterEntity>()
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
        this.setOnItemClickListener(OnItemClickListener { adapterView, view, i, l ->
            selectedItem = adapterView.adapter.getItem(i) as MasterEntity
            itemposition = i
        })

    }

    fun getAutoCompleteSelectedItem(): MasterEntity {
        return selectedItem
    }

    fun getAutoCompletePosition(): Int {
        return itemposition
    }

    fun autoFillById(id: String) {

        if (list_Item != null) {
            for (i in list_Item.indices) {
                if (list_Item.get(i).Id.equals(id)) {
                    selectedItem = list_Item.get(i)
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
                    selectedItem = list_Item.get(i)
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
                    selectedItem = list_Item.get(i)
                    this.setText(list_Item.get(i).Name)
                    break;
                }
            }
        }
    }
}


