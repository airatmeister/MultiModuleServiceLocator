package commultimodule.servicelocator.sl.dependencies

import androidx.lifecycle.ViewModel
import com.example.dashboard.sl.DashboardModuleProvider
import com.example.home.sl.HomeModuleProvider
import com.example.notifications.sl.NotificationsModuleProvider
import com.test.core.sl.DependencyContainer
import com.test.core.sl.base.BaseModule
import commultimodule.servicelocator.sl.modules.CoreModule

class FeaturesDependencyContainer(
    coreModule: CoreModule,
    private val dependencyContainer: DependencyContainer
) : DependencyContainer {

    private val dashboardModuleProvider = DashboardModuleProvider(dependencyContainer)
    private val homeModuleProvider = HomeModuleProvider(dependencyContainer)
    private val notificationsModuleProvider = NotificationsModuleProvider(
        coreModule.getApplicationContext(),
        dependencyContainer
    )

    override fun <T : ViewModel> module(clazz: Class<T>): BaseModule<*> =
        when(clazz){
            in dashboardModuleProvider.getArrayOfViewModels() -> dashboardModuleProvider.provide(clazz)
            in homeModuleProvider.getArrayOfViewModels() -> homeModuleProvider.provide(clazz)
            in notificationsModuleProvider.getArrayOfViewModels() -> notificationsModuleProvider.provide(clazz)
            else -> dependencyContainer.module(clazz)
        }
}