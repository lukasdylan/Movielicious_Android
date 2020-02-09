package plugin

import config.configureLibraryAndroid
import dependencies.configureDataMovieDependencies
import org.gradle.api.Project

/**
 * Created by lukasdylan on 2020-01-13
 */
open class DataMovieModulePlugin : BaseLibraryModulePlugin() {

    override fun Project.applyModuleDependencies() {
        configureDataMovieDependencies()
    }

    override fun Project.applyLibraryAndroid() {
        configureLibraryAndroid {
            it.buildConfigField("String", "MOVIE_API_BASE_URL", "\"https://api.themoviedb.org/\"")
            it.buildConfigField("String", "MOVIE_IMAGE_BASE_URL", "\"https://image.tmdb.org/t/p/\"")
            it.buildConfigField("String", "MOVIE_API_KEY", "\"5b878cc20daaf1cc00ca27b2e9909ead\"")
        }
    }
}