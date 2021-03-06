package dependencies

import ConfigurationType
import Dependency
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Created by lukasdylan on 2020-01-11
 */
internal fun Project.configureCoreDependencies() = dependencies {
    add(
        ConfigurationType.IMPLEMENTATION,
        fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar")))
    )
    add(ConfigurationType.API, Dependency.KOTLIN_STD_LIBRARY)
    add(ConfigurationType.API, Dependency.CORE_KTX)
    add(ConfigurationType.IMPLEMENTATION, Dependency.VIEWMODEL)
    add(ConfigurationType.IMPLEMENTATION, Dependency.VIEWMODEL_KTX)
    add(ConfigurationType.IMPLEMENTATION, Dependency.LIVEDATA_KTX)
    add(ConfigurationType.API, Dependency.RETROFIT)
    add(ConfigurationType.IMPLEMENTATION, Dependency.RETROFIT_CONVERTER_MOSHI)
    add(ConfigurationType.IMPLEMENTATION, Dependency.OKHTTP3_LOGGING_INTERCEPTOR)
    add(ConfigurationType.API, Dependency.TIMBER)
    add(ConfigurationType.API, Dependency.DAGGER)
    add(ConfigurationType.API, Dependency.DAGGER_ANDROID)
    add(ConfigurationType.API, Dependency.COROUTINES_CORE)
    add(ConfigurationType.API, Dependency.COROUTINES_ANDROID)
    add(ConfigurationType.KOTLIN_ANNOTATION_PROCESSOR, Dependency.DAGGER_COMPILER)
    add(ConfigurationType.KOTLIN_ANNOTATION_PROCESSOR, Dependency.DAGGER_ANDROID_PROCESSOR)
    add(ConfigurationType.TEST_IMPLEMENTATION, Dependency.JUNIT)
    add(ConfigurationType.ANDROID_TEST_IMPLEMENTATION, Dependency.TEST_EXT_JUNIT)
    add(ConfigurationType.ANDROID_TEST_IMPLEMENTATION, Dependency.TEST_ESPRESSO_CORE)
}
