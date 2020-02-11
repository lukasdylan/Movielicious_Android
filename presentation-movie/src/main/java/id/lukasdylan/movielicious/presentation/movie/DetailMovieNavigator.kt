package id.lukasdylan.movielicious.presentation.movie

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.movielicious.core.base.Navigator

/**
 * Created by lukasdylan on 2020-02-09
 */
sealed class DetailMovieNavigator : Navigator {

    private class MovieOverviewNavigator(private val overview: String) : DetailMovieNavigator() {
        override fun navigateFrom(fragment: Fragment) {
            val directions = DetailMovieFragmentDirections.openMovieOverviewScreen(overview)
            fragment.findNavController().navigate(directions)
        }
    }

    private class CastCreditsNavigator(private val dataCast: Array<Cast>) : DetailMovieNavigator() {
        override fun navigateFrom(fragment: Fragment) {
            val directions = DetailMovieFragmentDirections.openCreditListScreen(dataCast)
            fragment.findNavController().navigate(directions)
        }
    }

    companion object {

        @JvmStatic
        fun navigateToMovieOverviewScreen(overview: String): DetailMovieNavigator =
            MovieOverviewNavigator(overview)

        @JvmStatic
        fun navigateToCastCreditsScreen(dataCast: Array<Cast>): DetailMovieNavigator =
            CastCreditsNavigator(dataCast)
    }
}