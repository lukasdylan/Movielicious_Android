package plugin

import dependencies.configurePresentationHomeDependencies
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

/**
 * Created by lukasdylan on 2020-01-13
 */

open class PresentationHomeModulePlugin : BaseLibraryModulePlugin() {
    override fun Project.applyModuleDependencies() {
        configure<AndroidExtensionsExtension> {
            isExperimental = true
        }
        configurePresentationHomeDependencies()
    }
}