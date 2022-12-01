package `in`.probusinsurance.probusfrontend

import `in`.probusinsurance.probusdesign.MasterEntity
import `in`.probusinsurance.probusfrontend.databinding.FragmentTestBinding
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class TestFragment : BaseFragment<FragmentTestBinding, TestViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_test
    }

    override fun buildViewModel(): TestViewModel {
        return ViewModelProvider(this).get(TestViewModel::class.java)
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
        binding.spinner.setSpinner(requireActivity(), list)
    }

    override fun initLiveDataObservers() {
        binding.spinner.selectedItem.observe(this, Observer {
            Toast.makeText(
                context,
                it.Name + " : " + it.Id,
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    override fun onClickListener() {
    }


}