package plugin

import config.configureKotlinAndroidPlugins
import config.configureLibraryPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Created by lukasdylan on 2020-01-29
 */
abstract class BaseLibraryModulePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.configureLibraryPlugin()
        target.configureKotlinAndroidPlugins()
        target.applyLibraryAndroid()
        target.tasks.withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        target.applyModuleDependencies()
    }

    abstract fun Project.applyModuleDependencies()

    abstract fun Project.applyLibraryAndroid()
}
