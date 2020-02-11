package id.lukasdylan.movielicious.presentation.movie.overview

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import id.lukasdylan.movielicious.core.ui.base.BaseBottomSheetDialogFragment
import id.lukasdylan.movielicious.presentation.movie.R
import kotlinx.android.synthetic.main.fragment_movie_overview.*

/**
 * Created by lukasdylan on 2020-02-09
 */
class MovieOverviewFragment : BaseBottomSheetDialogFragment(R.layout.fragment_movie_overview) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieOverviewFragmentArgs by navArgs<MovieOverviewFragmentArgs>()
        tv_overview?.text = movieOverviewFragmentArgs.overview
    }
}