package `in`.probusinsurance.probusfrontend

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<T:ViewDataBinding,V:ViewModel>:AppCompatActivity() {

    private var _binding: T? = null
    protected val binding get() = _binding!!
    protected val viewModel by lazy { buildViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, getLayoutId())
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