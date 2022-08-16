package commultimodule.servicelocator.sl.modules

import android.content.Context
import com.test.core.sl.base.BaseModule
import commultimodule.servicelocator.presentation.MainActivityViewModel

class CoreModule: BaseModule<MainActivityViewModel> {

    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }

    override fun viewModel() = MainActivityViewModel()

    fun getApplicationContext() = context
}