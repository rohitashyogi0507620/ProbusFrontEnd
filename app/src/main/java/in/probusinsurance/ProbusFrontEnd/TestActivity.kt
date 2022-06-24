package `in`.probusinsurance.ProbusFrontEnd

import `in`.probusinsurance.probusdesign.MasterEntity
import `in`.probusinsurance.probusdesign.UI.HeadingWithCustomChipLayout
import `in`.probusinsurance.probusdesign.UI.HeadingWithFixChipLayout
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        var yesnolayout = findViewById<HeadingWithFixChipLayout>(R.id.layout_yesno)
        var whatsapp = findViewById<HeadingWithFixChipLayout>(R.id.whatsapp)
        yesnolayout.ischecked.observe(this, Observer {
            Toast.makeText(
                applicationContext,
                "${it.toString()} + ${yesnolayout.title()}",
                Toast.LENGTH_SHORT
            ).show()
        })

        whatsapp.ischecked.observe(this, Observer {
            Toast.makeText(
                applicationContext,
                "${it.toString()} + ${whatsapp.title()}",
                Toast.LENGTH_SHORT
            ).show()
        })

        var customlayout = findViewById<HeadingWithCustomChipLayout>(R.id.layout_city)
        // customlayout.setChipItems(this, resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.array_resistrationyear))
        //customlayout.setChipItems(this, resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.IdArray_City), resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.NameArray_City))
        //customlayout.autoFillById("2020")
        //customlayout.autoFillById("AJ")
        var data = resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.NameArray_City)
        var datalist: MutableList<MasterEntity>
        datalist = mutableListOf()
        data.forEachIndexed { index, s ->
            datalist.add(MasterEntity(index.toString(), s))

        }
        customlayout.setChipItems(this, datalist)
        customlayout.autoFillByMaster(MasterEntity("JAI", "Jaipur"))
        customlayout.selectedItem.observe(this, Observer {
            Toast.makeText(applicationContext, "${it.Name} + ${it.Id}", Toast.LENGTH_SHORT).show()
        })


    }
}