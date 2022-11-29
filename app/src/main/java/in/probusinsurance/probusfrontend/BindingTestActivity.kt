package `in`.probusinsurance.probusfrontend

import `in`.probusinsurance.probusfrontend.databinding.ActivityBindingTestBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil

class BindingTestActivity : AppCompatActivity() {

    lateinit var binding: ActivityBindingTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_binding_test)

        binding.btntest.setOnClickListener {
            Toast.makeText(applicationContext,"Hello",Toast.LENGTH_SHORT).show()
        }
    }
}