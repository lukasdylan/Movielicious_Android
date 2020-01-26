package id.lukasdylan.data.movie.datamanager

import id.lukasdylan.data.movie.BuildConfig
import id.lukasdylan.data.movie.model.MovieEntity
import id.lukasdylan.data.movie.model.MovieListResponse
import id.lukasdylan.data.movie.service.MovieApiService
import id.lukasdylan.movielicious.core.di.LanguagePreferences
import id.lukasdylan.movielicious.core.extension.awaitResult
import id.lukasdylan.movielicious.core.preferences.Preference
import id.lukasdylan.movielicious.core.utils.DataResult
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by lukasdylan on 2020-01-25
 */
interface MovieDataManager {
    suspend fun loadDiscoverList(): DataResult<MovieListResponse>
    suspend fun loadDetailMovie(movieId: Int): DataResult<MovieEntity>
}

@Singleton
class MovieDataManagerImpl @Inject constructor(
    private val movieApiService: MovieApiService,
    @LanguagePreferences private val languagePreference: Preference<String>
) : MovieDataManager {

    override suspend fun loadDiscoverList(): DataResult<MovieListResponse> {
        return movieApiService.fetchMovieList(BuildConfig.MOVIE_API_KEY, languageUsed())
            .awaitResult()
    }

    override suspend fun loadDetailMovie(movieId: Int): DataResult<MovieEntity> {
        return movieApiService.fetchDetailMovie(movieId, BuildConfig.MOVIE_API_KEY, languageUsed())
            .awaitResult()
    }

    private suspend fun languageUsed(): String = languagePreference.getValue()
}