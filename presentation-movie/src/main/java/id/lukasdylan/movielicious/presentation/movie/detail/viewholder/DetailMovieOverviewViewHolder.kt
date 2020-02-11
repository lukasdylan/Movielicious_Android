package id.lukasdylan.movielicious.presentation.movie.detail.viewholder

import android.view.View
import androidx.navigation.findNavController
import id.lukasdylan.movielicious.core.ui.base.BaseViewHolder
import id.lukasdylan.movielicious.presentation.movie.detail.DetailMovieFragmentDirections
import kotlinx.android.synthetic.main.item_overview_detail_movie.*

/**
 * Created by lukasdylan on 2020-02-11
 */
class DetailMovieOverviewViewHolder(view: View) : BaseViewHolder(view) {

    fun bind(overview: String) {
        tv_overview?.text = overview
        tv_more_overview?.setOnClickListener {
            val directions =
                DetailMovieFragmentDirections.openMovieOverviewScreen(overview)
            it.findNavController().navigate(directions)
        }
    }
}