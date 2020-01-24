package config

import org.gradle.api.Project

/**
 * Created by lukasdylan on 2020-01-12
 */
internal fun Project.configureKotlinAndroidPlugins(useKapt: Boolean = false) = with(plugins) {
    apply("kotlin-android")
    apply("kotlin-android-extensions")
    if (useKapt) {
        apply("kotlin-kapt")
    }
}