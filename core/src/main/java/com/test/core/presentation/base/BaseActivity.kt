package com.test.core.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding
import com.test.core.presentation.Navigator
import com.test.core.presentation.UiAction
import com.test.core.sl.ProvideViewModel

abstract class BaseActivity<VB: ViewBinding, T: ViewModel> :
    AppCompatActivity,
    Navigator,
    ProvideViewModel
{

    protected lateinit var viewModel: T

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T =
        (application as ProvideViewModel).provideViewModel(clazz, owner)

    constructor() : super()
    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)

    lateinit var binding: VB
    protected abstract fun initVB() : VB

    protected lateinit var navigator: NavController
    abstract override fun getNavController(): NavController
    abstract override fun navigateTo(action: UiAction)

    fun navigateTo(action: String, bundle: Bundle? = null){
        navigateTo(UiAction(action, bundle))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initVB()
        setContentView(binding.root)
    }

    abstract fun onSetupLayout()

    override fun onStart() {
        super.onStart()
        navigator = getNavController()
        onSetupLayout()
    }
}