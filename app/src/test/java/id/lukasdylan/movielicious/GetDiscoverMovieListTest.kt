package id.lukasdylan.movielicious

import id.lukasdylan.data.movie.datamanager.MovieDataManager
import id.lukasdylan.data.movie.model.MovieListResponse
import id.lukasdylan.data.movie.model.MovieResponse
import id.lukasdylan.domain.movie.usecase.GetDiscoverMovieList
import id.lukasdylan.domain.movie.usecase.GetDiscoverMovieListResult
import id.lukasdylan.movielicious.core.utils.DataResult
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

/**
 * Created by lukasdylan on 2020-02-11
 */
class GetDiscoverMovieListTest {

    @Rule
    @JvmField
    val rule: MockitoRule = MockitoJUnit.rule()

    @Rule
    @JvmField
    val dispatcherRule: DispatcherProviderRule = DispatcherProviderRule()

    @Mock
    lateinit var movieDataManager: MovieDataManager

    private lateinit var getDiscoverMovieList: GetDiscoverMovieList

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getDiscoverMovieList =
            GetDiscoverMovieList(movieDataManager, dispatcherRule.dispatcherProvider)
    }

    @Test
    fun `success load discover movie list with return one item`() {
        runBlocking {
            val expectedResponse = MovieListResponse(
                listOf(
                    MovieResponse(
                        id = 0,
                        title = "Test Title",
                        voteAverage = 0.0,
                        voteCount = 0,
                        overview = "",
                        posterPath = "",
                        genres = emptyList(),
                        backdropPath = "",
                        releaseDate = "",
                        runtime = 0
                    )
                )
            )

            Mockito.`when`(movieDataManager.loadDiscoverList())
                .thenReturn(DataResult.Success(expectedResponse))

            val result = getDiscoverMovieList.getResult()

            Assert.assertTrue(result is GetDiscoverMovieListResult.Success)
            Assert.assertTrue((result as GetDiscoverMovieListResult.Success).data.isNotEmpty())
            Assert.assertFalse(result.data.first().title == "Test Titleeee")
        }

    }
}