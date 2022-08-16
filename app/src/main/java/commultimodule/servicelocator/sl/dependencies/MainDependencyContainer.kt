package commultimodule.servicelocator.sl.dependencies

import androidx.lifecycle.ViewModel
import com.test.core.sl.DependencyContainer
import com.test.core.sl.base.BaseModule
import commultimodule.servicelocator.presentation.MainActivityViewModel
import commultimodule.servicelocator.sl.modules.CoreModule
import commultimodule.servicelocator.sl.modules.MainModule

class MainDependencyContainer(
    private val dependencyContainer: DependencyContainer,
    private val coreModule: CoreModule
) : DependencyContainer {

    override fun <T : ViewModel> module(clazz: Class<T>): BaseModule<*> =
        if (clazz == MainActivityViewModel::class.java)
            MainModule(coreModule)
        else
            dependencyContainer.module(clazz)
}