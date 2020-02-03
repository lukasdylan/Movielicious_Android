package config

import org.gradle.api.Project

/**
 * Created by lukasdylan on 2020-01-12
 */
internal fun Project.configureKotlinAndroidPlugins() = with(plugins) {
    apply("kotlin-android")
    apply("kotlin-android-extensions")
    apply("kotlin-kapt")
    apply("androidx.navigation.safeargs.kotlin")
}