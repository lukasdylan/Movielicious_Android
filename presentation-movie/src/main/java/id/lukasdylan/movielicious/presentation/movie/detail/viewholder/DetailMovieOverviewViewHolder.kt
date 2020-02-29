package id.lukasdylan.movielicious.presentation.movie.detail.viewholder

import android.view.View
import androidx.navigation.findNavController
import id.lukasdylan.movielicious.core.ui.base.BaseViewHolder
import id.lukasdylan.movielicious.presentation.movie.detail.DetailMovieFragmentDirections
import kotlinx.android.synthetic.main.item_overview_detail_movie.*

/**
 * Created by lukasdylan on 2020-02-11
 */
class DetailMovieOverviewViewHolder(view: View) : BaseViewHolder<String>(view) {

    override fun bind(item: String) {
        tv_overview?.text = item
        tv_more_overview?.setOnClickListener {
            val directions =
                DetailMovieFragmentDirections.openMovieOverviewScreen(item)
            it.findNavController().navigate(directions)
        }
    }
}