package `in`.probusinsurance.probusfrontend

import `in`.probusinsurance.probusdesign.MasterEntity
import `in`.probusinsurance.probusdesign.ui.dialog.AlertDialog
import `in`.probusinsurance.probusfrontend.databinding.ActivityBindingTestBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class BindingTestActivity : BaseActivity<ActivityBindingTestBinding, TestViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_binding_test
    }

    override fun getBundle() {
    }

    override fun initViews() {
        var list = arrayListOf<MasterEntity>()
        list.add(MasterEntity("Select Education *", "Select Education *"))
        list.add(MasterEntity("12", "12 th Pass"))
        list.add(MasterEntity("10", "10 th Pass"))
        list.add(MasterEntity("15", "Graduation"))
        list.add(MasterEntity("18 ", "Post Graduation"))
        binding.spinner.setSpinner(this, list)

        val transaction = supportFragmentManager.beginTransaction()
        val fragment: Fragment = TestFragment()
        transaction.addToBackStack(null)
        val bundle = Bundle()
        bundle.putString("rgd", "12345")
        fragment.arguments = bundle
        transaction.replace(R.id.frame_car_insurance, fragment)
        transaction.commit()

    }

    override fun initLiveDataObservers() {


        binding.spinner.selectedItem.observe(this, Observer {
            Toast.makeText(
                applicationContext,
                it.Name + " : " + it.Id,
                Toast.LENGTH_SHORT
            ).show()
        })


    }



    override fun onClickListener() {

        binding.btntest.setOnClickListener {
            Toast.makeText(applicationContext, "Hello", Toast.LENGTH_SHORT).show()
        }
        binding.bntback.setOnClickListener {
            Toast.makeText(applicationContext, "Back Button", Toast.LENGTH_SHORT).show()

        }
        binding.libtestbtn.setOnClickListener {
            Toast.makeText(applicationContext, "Lib Back Button", Toast.LENGTH_SHORT).show()

        }
    }

    override fun buildViewModel(): TestViewModel {
        return ViewModelProvider(this).get(TestViewModel::class.java)
    }


}