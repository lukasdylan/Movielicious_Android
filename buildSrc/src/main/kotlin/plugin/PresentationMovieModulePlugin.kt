package plugin

import config.configureLibraryAndroid
import dependencies.configurePresentationMovieDependencies
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

/**
 * Created by lukasdylan on 2020-01-13
 */

open class PresentationMovieModulePlugin : BaseLibraryModulePlugin() {
    override fun Project.applyModuleDependencies() {
        configure<AndroidExtensionsExtension> {
            isExperimental = true
        }
        configurePresentationMovieDependencies()
    }

    override fun Project.applyLibraryAndroid() {
        configureLibraryAndroid()
    }
}