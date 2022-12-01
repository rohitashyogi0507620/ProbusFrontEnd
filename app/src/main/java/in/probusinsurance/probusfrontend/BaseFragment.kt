package `in`.probusinsurance.probusfrontend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<T: ViewDataBinding,V: ViewModel>:Fragment() {
    private var _binding: T? = null
    protected val binding get() = _binding!!
    protected val viewModel by lazy { buildViewModel() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBundle()
        initViews()
        initLiveDataObservers()
        onClickListener()

    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun buildViewModel(): V

    open fun getBundle() {

    }

    open fun initViews() {

    }

    open fun initLiveDataObservers() {

    }
    open fun onClickListener() {

    }
}