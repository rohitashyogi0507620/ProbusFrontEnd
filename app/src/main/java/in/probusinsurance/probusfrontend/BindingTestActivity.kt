package `in`.probusinsurance.probusfrontend

import `in`.probusinsurance.probusdesign.MasterEntity
import `in`.probusinsurance.probusfrontend.databinding.ActivityBindingTestBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

class BindingTestActivity : AppCompatActivity() {

    lateinit var binding: ActivityBindingTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_binding_test)

        binding.btntest.setOnClickListener {
            Toast.makeText(applicationContext,"Hello",Toast.LENGTH_SHORT).show()
        }
        binding.bntback.setOnClickListener{
            Toast.makeText(applicationContext,"Back Button",Toast.LENGTH_SHORT).show()

        }
        binding.libtestbtn.setOnClickListener{
            Toast.makeText(applicationContext,"Lib Back Button",Toast.LENGTH_SHORT).show()

        }

        var list = arrayListOf<MasterEntity>()
        list.add(MasterEntity("Select Education *", "Select Education *"))
        list.add(MasterEntity("12", "12 th Pass"))
        list.add(MasterEntity("10", "10 th Pass"))
        list.add(MasterEntity("15", "Graduation"))
        list.add(MasterEntity("18 ", "Post Graduation"))
        binding.spinner.setSpinner(this, list)
       // spinner.autoFillByName("Graduation")
        // spinner.autoFillById("10")
        // spinner.autoFillByMaster(MasterEntity("18 ", "Post Graduation"))

        binding.spinner.selectedItem.observe(this, Observer {
            Toast.makeText(
                applicationContext,
                it.Name + " : " + it.Id,
                Toast.LENGTH_SHORT
            ).show()
        })
//        binding.spinner.setSpinner(
//            this,
//            resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.Idarray_yesno),
//            resources.getStringArray(`in`.probusinsurance.probusdesign.R.array.array_yesno)
//        )

    }
}