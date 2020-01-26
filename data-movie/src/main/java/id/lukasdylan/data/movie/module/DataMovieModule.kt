package id.lukasdylan.data.movie.module

import dagger.Module
import dagger.Provides
import id.lukasdylan.data.movie.BuildConfig
import id.lukasdylan.data.movie.datamanager.MovieDataManager
import id.lukasdylan.data.movie.datamanager.MovieDataManagerImpl
import id.lukasdylan.data.movie.service.MovieApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by lukasdylan on 2020-01-25
 */
@Module
class DataMovieModule {

    @Provides
    @Singleton
    fun provideMovieApiService(
        okHttpClient: OkHttpClient,
        factory: MoshiConverterFactory
    ): MovieApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.MOVIE_API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(factory)
            .build()
        return retrofit.create(MovieApiService::class.java)
    }

    @Provides
    fun provideDataManager(dataManagerImpl: MovieDataManagerImpl): MovieDataManager =
        dataManagerImpl
}