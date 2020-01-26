package plugin

import config.configureKotlinAndroidPlugins
import config.configureLibraryAndroid
import config.configureLibraryPlugin
import dependencies.configureDomainMovieDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Created by lukasdylan on 2020-01-13
 */
open class DomainMovieModulePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.configureLibraryPlugin()
        target.configureKotlinAndroidPlugins(useKapt = true)
        target.configureLibraryAndroid()
        target.tasks.withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        target.configureDomainMovieDependencies()
    }
}