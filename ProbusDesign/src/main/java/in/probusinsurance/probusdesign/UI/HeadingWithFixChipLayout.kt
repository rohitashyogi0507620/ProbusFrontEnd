package `in`.probusinsurance.probusdesign.UI

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class HeadingWithFixChipLayout(context: Context, attrs: AttributeSet) :

    LinearLayout(context, attrs) {


    private var _ischecked = MutableLiveData<Boolean>()
    val ischecked: LiveData<Boolean>
        get() = _ischecked!!


    private var _withoutchip = MutableLiveData<Boolean>()
    val withoutchip: LiveData<Boolean>
        get() = _withoutchip!!

    private var _chipgroup: ChipGroup? = null
    val chipgroup get() = _chipgroup!!

    private var _chipfirst: Chip? = null
    val chipfirst get() = _chipfirst!!

    private var _chipsecound: Chip? = null
    val chipsecound get() = _chipsecound!!

    private var _heading: TextView? = null
    val heading get() = _heading!!

    private var _subheading: TextView? = null
    val subheading get() = _subheading!!


    init {


        inflate(context, R.layout.layout_heading_fix_chip, this)

        val customAttributesStyle =
            context.obtainStyledAttributes(attrs, R.styleable.HeadingWithFixChipLayout, 0, 0)
        _heading = findViewById(R.id.txt_heading)
        _subheading = findViewById(R.id.txt_subheading)
        _chipgroup = findViewById(R.id.chip_group)
        _chipfirst = findViewById(R.id.chip_yes)
        _chipsecound = findViewById(R.id.chip_no)

        try {

            heading.text = customAttributesStyle.getText(R.styleable.HeadingWithFixChipLayout_title)
            subheading.text =
                customAttributesStyle.getString(R.styleable.HeadingWithFixChipLayout_subtitle)
            var ischipFix = customAttributesStyle.getBoolean(
                R.styleable.HeadingWithFixChipLayout_isCustomChip,
                false
            )
            if (ischipFix) {
                chipfirst.text =
                    customAttributesStyle.getString(R.styleable.HeadingWithFixChipLayout_chip1Text)
                chipsecound.text =
                    customAttributesStyle.getString(R.styleable.HeadingWithFixChipLayout_chip2Text)
            }

            _ischecked.value = customAttributesStyle.getBoolean(
                R.styleable.HeadingWithFixChipLayout_ischecked,
                false
            )
            ischecked(_ischecked.value!!)

            _withoutchip.value = customAttributesStyle.getBoolean(
                R.styleable.HeadingWithFixChipLayout_withoutchip,
                false
            )
            withoutChip(_withoutchip.value!!)

            chipgroup.setOnCheckedChangeListener(ChipGroup.OnCheckedChangeListener { group, checkedId ->
                if (checkedId == R.id.chip_yes) {
                    _ischecked.value = true
                } else {
                    _ischecked.value = false
                }
            })

        } finally {
            customAttributesStyle.recycle()
        }


        invalidate()
        requestLayout()


    }

    fun ischecked(check: Boolean) {
        _ischecked.value = check
        if (_ischecked.value!!) {
            chipgroup.check(R.id.chip_yes)
        } else {
            chipgroup.check(R.id.chip_no)

        }
    }

    fun withoutChip(check: Boolean) {
        _ischecked.value = check
        if (_ischecked.value!!) {
            chipgroup.visibility = View.GONE
        } else {
            chipgroup.visibility = View.VISIBLE
        }
    }

    fun ischecked(): Boolean {
        return _ischecked.value!!
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

    fun chip1Text(text: String) {
        chipfirst.text = text
    }

    fun chip1Text(): String {
        return chipfirst.text.toString()
    }

    fun chip2Text(text: String) {
        chipsecound.text = text
    }

    fun chip2Text(): String {
        return chipsecound.text.toString()
    }


}