package `in`.probusinsurance.probusfrontend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val transaction = supportFragmentManager.beginTransaction()
        val fragment: Fragment = TestFragment()
        transaction.addToBackStack(null)
        val bundle = Bundle()
        bundle.putString("rgd", "12345")
        fragment.arguments = bundle
        transaction.replace(R.id.frame_car_insurance, fragment)
        transaction.commit()

    }
}