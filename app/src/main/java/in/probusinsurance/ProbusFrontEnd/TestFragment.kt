package `in`.probusinsurance.ProbusFrontEnd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class TestFragment : Fragment() {

    companion object {
        fun newInstance() = TestFragment()
    }

    private lateinit var viewModel: TestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)
//        val alertdialog: Dialog = AlertDialog.ErrorDialog(requireActivity(), "Hello Bro This is erro dialog")
//        val btnok = alertdialog.findViewById<Button>(`in`.probusinsurance.probusdesign.R.id.btn_ok)
//        btnok.setOnClickListener { view1: View? -> alertdialog.dismiss() }
   //     loadTable()

    }


}