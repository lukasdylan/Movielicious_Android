package config

import org.gradle.api.Project

/**
 * Created by lukasdylan on 2020-01-12
 */
internal fun Project.configureAppPlugin() {
    plugins.apply("com.android.application")
}

internal fun Project.configureLibraryPlugin() {
    plugins.apply("com.android.library")
}