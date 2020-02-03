package plugin

import dependencies.configureCoreUiDependencies
import org.gradle.api.Project

/**
 * Created by lukasdylan on 2020-01-13
 */

open class CoreUiModulePlugin : BaseLibraryModulePlugin() {
    override fun Project.applyModuleDependencies() {
        configureCoreUiDependencies()
    }
}