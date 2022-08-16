package commultimodule.servicelocator.sl.modules

import com.test.core.sl.base.BaseModule
import commultimodule.servicelocator.presentation.MainActivityViewModel

class MainModule(private val coreModule: CoreModule) : BaseModule<MainActivityViewModel> {

    override fun viewModel() = MainActivityViewModel()
}