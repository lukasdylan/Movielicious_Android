package id.lukasdylan.data.movie.service

import id.lukasdylan.data.movie.model.MovieEntity
import id.lukasdylan.data.movie.model.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by lukasdylan on 2020-01-25
 */
private const val DISCOVER_MOVIE_ENDPOINT = "/3/discover/movie"
private const val DETAIL_MOVIE_ENDPOINT = "/3/movie/{movie_id}"

interface MovieApiService {
    @GET(DISCOVER_MOVIE_ENDPOINT)
    fun fetchMovieList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("region") region: String = "ID"
    ): Call<MovieListResponse>

    @GET(DETAIL_MOVIE_ENDPOINT)
    fun fetchDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("region") region: String = "ID"
    ): Call<MovieEntity>
}