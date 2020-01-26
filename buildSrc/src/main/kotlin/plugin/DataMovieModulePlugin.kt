package plugin

import config.configureKotlinAndroidPlugins
import config.configureLibraryAndroid
import config.configureLibraryPlugin
import dependencies.configureDataMovieDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Created by lukasdylan on 2020-01-13
 */
open class DataMovieModulePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.configureLibraryPlugin()
        target.configureKotlinAndroidPlugins(useKapt = true)
        target.configureLibraryAndroid {
            it.buildConfigField("String", "MOVIE_API_BASE_URL", "\"https://api.themoviedb.org/\"")
            it.buildConfigField("String", "MOVIE_IMAGE_BASE_URL", "\"https://image.tmdb.org/t/p/\"")
            it.buildConfigField("String", "MOVIE_API_KEY", "\"5b878cc20daaf1cc00ca27b2e9909ead\"")
        }
        target.tasks.withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        target.configureDataMovieDependencies()
    }
}