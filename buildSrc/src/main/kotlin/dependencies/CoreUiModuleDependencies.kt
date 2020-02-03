package dependencies

import ConfigurationType
import Dependency
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Created by lukasdylan on 2020-01-11
 */
internal fun Project.configureCoreUiDependencies() = dependencies {
    add(
        ConfigurationType.IMPLEMENTATION,
        fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar")))
    )
    add(ConfigurationType.IMPLEMENTATION, Dependency.KOTLIN_STD_LIBRARY)
    add(ConfigurationType.API, Dependency.APPCOMPAT)
    add(ConfigurationType.API, Dependency.GOOGLE_MATERIAL)
    add(ConfigurationType.API, Dependency.CONSTRAINT_LAYOUT)
    add(ConfigurationType.IMPLEMENTATION, Dependency.TIMBER)
    add(ConfigurationType.IMPLEMENTATION, Dependency.OKHTTP3_LOGGING_INTERCEPTOR)
    add(ConfigurationType.API, Dependency.COIL)
    add(ConfigurationType.API, Dependency.NAVIGATION_RUNTIME)
    add(ConfigurationType.API, Dependency.NAVIGATION_FRAGMENT)
    add(ConfigurationType.API, Dependency.NAVIGATION_UI)
    add(ConfigurationType.API, Dependency.FRAGMENT_KTX)
    add(ConfigurationType.API, Dependency.VIEWMODEL_KTX)
    add(ConfigurationType.API, Dependency.LIVEDATA_KTX)
}
