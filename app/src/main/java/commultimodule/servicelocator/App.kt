package commultimodule.servicelocator

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.test.core.sl.DependencyContainer
import com.test.core.sl.ProvideViewModel
import com.test.core.sl.ViewModelFactory
import commultimodule.servicelocator.sl.dependencies.FeaturesDependencyContainer
import commultimodule.servicelocator.sl.dependencies.MainDependencyContainer
import commultimodule.servicelocator.sl.modules.CoreModule

class App: Application(), ProvideViewModel {

    private val coreModule = CoreModule()

    private lateinit var viewModelsFactory: ViewModelFactory

    override fun onCreate() {
        super.onCreate()
        coreModule.init(this)
        val main = MainDependencyContainer(DependencyContainer.Error(), coreModule)
        viewModelsFactory = ViewModelFactory(FeaturesDependencyContainer(coreModule, main))
    }

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T =
        ViewModelProvider(owner, viewModelsFactory)[clazz]
}