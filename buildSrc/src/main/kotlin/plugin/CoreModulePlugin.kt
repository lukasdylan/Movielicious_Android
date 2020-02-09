package plugin

import config.configureLibraryAndroid
import dependencies.configureCoreDependencies
import org.gradle.api.Project

/**
 * Created by lukasdylan on 2020-01-13
 */

open class CoreModulePlugin : BaseLibraryModulePlugin() {
    override fun Project.applyModuleDependencies() {
        configureCoreDependencies()
    }

    override fun Project.applyLibraryAndroid() {
        configureLibraryAndroid()
    }
}