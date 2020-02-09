package plugin

import config.configureLibraryAndroid
import dependencies.configureDomainMovieDependencies
import org.gradle.api.Project

/**
 * Created by lukasdylan on 2020-01-13
 */

open class DomainMovieModulePlugin : BaseLibraryModulePlugin() {
    override fun Project.applyModuleDependencies() {
        configureDomainMovieDependencies()
    }

    override fun Project.applyLibraryAndroid() {
        configureLibraryAndroid()
    }
}