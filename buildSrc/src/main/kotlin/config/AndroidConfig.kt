package config

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.DefaultConfig
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

/**
 * Created by lukasdylan on 2020-01-11
 */
internal fun Project.configureAndroid() = this.extensions.getByType<AppExtension>().apply {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.2"

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        applicationId = "id.lukasdylan.movielicious"
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    configure<AndroidExtensionsExtension> {
        isExperimental = true
    }

    packagingOptions {
        exclude ("META-INF/ASL2.0")
        exclude ("META-INF/NOTICE.txt")
        exclude ("META-INF/notice.txt")
        exclude ("META-INF/NOTICE")
        exclude ("META-INF/LICENSE.txt")
        exclude ("META-INF/license.txt")
        exclude ("META-INF/LICENSE")
        exclude ("META-INF/DEPENDENCIES.txt")
        exclude ("META-INF/DEPENDENCIES")
        exclude ("META-INF/dependencies.txt")
        exclude ("META-INF/LGPL2.1")
        exclude ("META-INF/main.kotlin_module")
        exclude ("META-INF/movie_debug.kotlin_module")
    }
}

internal fun Project.configureLibraryAndroid(buildConfigCallback: (DefaultConfig) -> Unit = {}) =
    this.extensions.getByType<LibraryExtension>().apply {
        compileSdkVersion(29)
        buildToolsVersion = "29.0.2"

        defaultConfig {
            minSdkVersion(21)
            targetSdkVersion(29)
            versionCode = 1
            versionName = "1.0.0"
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

            buildConfigCallback.invoke(this)
        }

        buildTypes {
            getByName("release") {
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }

            getByName("debug") {
                isDebuggable = true
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }