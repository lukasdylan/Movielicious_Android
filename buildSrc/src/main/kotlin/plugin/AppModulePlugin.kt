package plugin

import config.configureAndroid
import config.configureAppPlugin
import config.configureKotlinAndroidPlugins
import dependencies.configureAppDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Created by lukasdylan on 2020-01-10
 */
open class AppModulePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.configureAppPlugin()
        target.configureKotlinAndroidPlugins(useKapt = true)
        target.configureAndroid()
        target.tasks.withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        target.configureAppDependencies()
    }
}
