package dependencies

import ConfigurationType
import Dependency
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Created by lukasdylan on 2020-01-11
 */
internal fun Project.configurePresentationHomeDependencies() = dependencies {
    add(
        ConfigurationType.IMPLEMENTATION,
        fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar")))
    )
    add(ConfigurationType.IMPLEMENTATION, project(":core"))
    add(ConfigurationType.IMPLEMENTATION, project(":core-ui"))
    add(ConfigurationType.IMPLEMENTATION, project(":domain-movie"))
    add(ConfigurationType.KOTLIN_ANNOTATION_PROCESSOR, Dependency.DAGGER_COMPILER)
    add(ConfigurationType.KOTLIN_ANNOTATION_PROCESSOR, Dependency.DAGGER_ANDROID_PROCESSOR)
    add(ConfigurationType.TEST_IMPLEMENTATION, Dependency.JUNIT)
    add(ConfigurationType.ANDROID_TEST_IMPLEMENTATION, Dependency.TEST_EXT_JUNIT)
    add(ConfigurationType.ANDROID_TEST_IMPLEMENTATION, Dependency.TEST_ESPRESSO_CORE)
}
