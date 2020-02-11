package id.lukasdylan.movielicious

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.lukasdylan.data.movie.datamanager.MovieDataManager
import id.lukasdylan.data.movie.model.MovieListResponse
import id.lukasdylan.domain.movie.usecase.GetDiscoverMovieList
import id.lukasdylan.movielicious.core.utils.DataResult
import id.lukasdylan.movielicious.presentation.home.HomeAction
import id.lukasdylan.movielicious.presentation.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

/**
 * Created by lukasdylan on 2020-02-11
 */
@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @Rule
    @JvmField
    val liveDataRule: TestRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val rule: MockitoRule = MockitoJUnit.rule()

    @Rule
    @JvmField
    val dispatcherRule: DispatcherProviderRule = DispatcherProviderRule()

    @Mock
    lateinit var movieDataManager: MovieDataManager

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val getDiscoverMovieList =
            GetDiscoverMovieList(movieDataManager, dispatcherRule.dispatcherProvider)
        homeViewModel = HomeViewModel(getDiscoverMovieList)
    }

    @Test
    fun `test load discover data but return empty list`() {
        runBlocking {
            Mockito.`when`(movieDataManager.loadDiscoverList()).thenReturn(
                DataResult.Success(MovieListResponse(emptyList()))
            )

            homeViewModel.execute(HomeAction.LoadDiscoverList)

            testLiveData(homeViewModel.viewState) {
                Assert.assertTrue(it?.data.isNullOrEmpty())
                Assert.assertFalse(it?.isLoading == true)
            }
        }
    }

}