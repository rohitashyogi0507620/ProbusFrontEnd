package `in`.probusinsurance.probusdesign.UI

import `in`.probusinsurance.probusdesign.MasterEntity
import `in`.probusinsurance.probusdesign.R
import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class HeadingWithCustomChipLayout(context: Context, attrs: AttributeSet) :

    LinearLayout(context, attrs) {


    private var _selectedItem = MutableLiveData<MasterEntity>()
    val selectedItem: LiveData<MasterEntity>
        get() = _selectedItem

    private var _itemposition = MutableLiveData<Int>()
    val itemposition: LiveData<Int>
        get() = _itemposition

    var _list_Item: List<MasterEntity>? = null
    val list_Item get() = _list_Item!!

    private var _chipgroup: ChipGroup? = null
    val chipgroup get() = _chipgroup!!

    private var _heading: TextView? = null
    val heading get() = _heading!!

    private var _subheading: TextView? = null
    val subheading get() = _subheading!!


    init {


        inflate(context, R.layout.layout_heading_customchip, this)

        val customAttributesStyle =
            context.obtainStyledAttributes(attrs, R.styleable.HeadingWithCustomChipLayout, 0, 0)
        _heading = findViewById(R.id.txt_heading)
        _subheading = findViewById(R.id.txt_subheading)
        _chipgroup = findViewById(R.id.chip_group)

        try {

            heading.text =
                customAttributesStyle.getText(R.styleable.HeadingWithCustomChipLayout_headingtitle)
            subheading.text =
                customAttributesStyle.getString(R.styleable.HeadingWithCustomChipLayout_subheadingtitle)

            chipgroup.setOnCheckedChangeListener(ChipGroup.OnCheckedChangeListener { group, checkedId ->
                var chip = chipgroup.findViewById(checkedId) as Chip
                autoFillByName(chip.text.toString())
            })


        } finally {
            customAttributesStyle.recycle()
        }


        invalidate()
        requestLayout()


    }


    fun title(text: String) {
        heading.text = text
    }

    fun subtitle(text: String) {
        subheading.text = text
    }

    fun title(): String {
        return heading.text.toString()
    }

    fun subtitle(): String {
        return subheading.text.toString()
    }


    fun setChipItems(context: Activity, list: List<MasterEntity>) {
        _list_Item = list
        for (i in list_Item.indices) {
            val chips: String = list_Item[i].Name
            var chip =
                context.layoutInflater.inflate(R.layout.layout_chip_item, null, false) as Chip
            chip.text = chips
            chip.id = View.generateViewId()
            chip.setTextAppearanceResource(R.style.Chip_Single_Style)
            val paddingDp = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                20f,
                resources.displayMetrics
            ).toInt()
            chip.setPadding(paddingDp, 0, paddingDp, 0)
            chipgroup.addView(chip)
        }


    }

    fun setChipItems(context: Activity, listId: Array<String>) {

        var listitem = mutableListOf<MasterEntity>()
        for (i in listId.indices) {
            listitem.add(MasterEntity(listId[i], listId[i]))
        }
        _list_Item = listitem

        for (i in list_Item.indices) {
            val chips: String = list_Item[i].Name
            var chip =
                context.layoutInflater.inflate(R.layout.layout_chip_item, null, false) as Chip
            chip.text = chips
            chip.id = View.generateViewId()
            chip.setTextAppearanceResource(R.style.Chip_Single_Style)
            val paddingDp = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                20f,
                resources.displayMetrics
            ).toInt()
            chip.setPadding(paddingDp, 0, paddingDp, 0)
            chipgroup.addView(chip)
        }


    }

    fun setChipItems(context: Activity, listId: Array<String>, listname: Array<String>) {

        var listitem = mutableListOf<MasterEntity>()
        for (i in listId.indices) {
            listitem.add(MasterEntity(listId[i], listname[i]))
        }
        _list_Item = listitem
        for (i in list_Item.indices) {
            val chips: String = list_Item[i].Name
            var chip =
                context.layoutInflater.inflate(R.layout.layout_chip_item, null, false) as Chip
            chip.text = chips
            chip.id = View.generateViewId()
            chip.setTextAppearanceResource(R.style.Chip_Single_Style)
            val paddingDp = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                20f,
                resources.displayMetrics
            ).toInt()
            chip.setPadding(paddingDp, 0, paddingDp, 0)
            chipgroup.addView(chip)
        }
    }


    fun autoFillById(id: String) {

        if (list_Item != null) {
            for (i in list_Item.indices) {
                if (list_Item.get(i).Id.equals(id)) {
                    var chip = chipgroup.getChildAt(i) as Chip
                    chipgroup.check(chip.id)
                    _selectedItem.postValue(list_Item.get(i))
                    break;
                }
            }
        }
    }

    fun autoFillByName(name: String) {

        if (list_Item != null) {
            for (i in list_Item.indices) {
                if (list_Item.get(i).Name.equals(name)) {
                    var chip = chipgroup.getChildAt(i) as Chip
                    chipgroup.check(chip.id)
                    _selectedItem.postValue(list_Item.get(i))
                    break;
                }
            }
        }
    }

    fun autoFillByMaster(item: MasterEntity) {
        if (list_Item != null) {
            for (i in list_Item.indices) {
                if (list_Item.get(i).Id.equals(item.Id) && list_Item.get(i).Name.equals(item.Name)) {
                    var chip = chipgroup.getChildAt(i) as Chip
                    chipgroup.check(chip.id)
                    _selectedItem.postValue(list_Item.get(i))
                    break;
                }
            }
        }
    }

}