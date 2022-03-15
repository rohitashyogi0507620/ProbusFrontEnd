package `in`.probusinsurance.probusdesign.UI.EditText;

import `in`.probusinsurance.probusdesign.R
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout


class EditTextInput(context: Context, attrs: AttributeSet?) : TextInputLayout(context, attrs) {

    val errorlayout: LinearLayout
    val textviewerror: TextView
    val imageviewerror: ImageView

    var showerror: Boolean
    var errormessage: String
    var errorIcon: Drawable?

    init {

        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.EditTextInput, 0, 0)

        val view: View = LayoutInflater.from(getContext()).inflate(R.layout.error_layout, null)
        errorlayout = view.findViewById(R.id.error_layout)
        textviewerror = view.findViewById(R.id.error_text)
        imageviewerror = view.findViewById(R.id.error_image)

        try {

            showerror = a.getBoolean(R.styleable.EditTextInput_showError, false)
            errormessage = a.getString(R.styleable.EditTextInput_errorMessage).toString()
            errorIcon = a.getDrawable(R.styleable.EditTextInput_errorIcon)
            setErrorLayout(showerror, errormessage, errorIcon)

        } finally {
            a.recycle()
        }
        setHelperTextTextAppearance(R.style.EditText_Style_Outline)
        setPadding(15, 0, 15, 0)
        this.addView(view)
    }

    fun setErrorLayout(isshow: Boolean, message: String, icon: Drawable?) {

        showerror = isshow
        errormessage = message
        errorIcon = icon

        if (showerror) {
            errorlayout.visibility = View.VISIBLE
            textviewerror.text = errormessage
            imageviewerror.setImageDrawable(errorIcon)
        } else {
            errorlayout.visibility = View.GONE
        }

    }

    fun setErrorText(text: String?) {
        textviewerror.text = text
    }
    fun setErrorTextColor(textcolor: Int) {
        textviewerror.setTextColor(textcolor)
    }

    fun setErrorLayout(showlayout: Boolean) {
        if (showlayout) {
            errorlayout.visibility -= View.VISIBLE
        } else {
            errorlayout.visibility -= View.GONE
        }
    }

    fun setErrorDrawableIcon(icon: Drawable?) {
        imageviewerror.setImageDrawable(icon)
    }
}
