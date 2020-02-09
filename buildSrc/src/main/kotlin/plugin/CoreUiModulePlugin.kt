package plugin

import config.configureLibraryAndroid
import dependencies.configureCoreUiDependencies
import org.gradle.api.Project

/**
 * Created by lukasdylan on 2020-01-13
 */

open class CoreUiModulePlugin : BaseLibraryModulePlugin() {
    override fun Project.applyModuleDependencies() {
        configureCoreUiDependencies()
    }

    override fun Project.applyLibraryAndroid() {
        configureLibraryAndroid {
            it.buildConfigField("String", "MOVIELICIOUS_HOSTNAME", "\"movieliciousapp://\"")
        }
    }
}