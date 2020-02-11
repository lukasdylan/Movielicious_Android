package id.lukasdylan.movielicious.presentation.movie.detail.viewholder

import android.view.View
import coil.api.load
import coil.transform.RoundedCornersTransformation
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.ui.base.BaseViewHolder
import id.lukasdylan.movielicious.core.ui.dpToPx
import id.lukasdylan.movielicious.presentation.movie.R
import kotlinx.android.synthetic.main.item_header_detail_movie.*

/**
 * Created by lukasdylan on 2020-02-11
 */
class DetailMovieHeaderViewHolder(view: View) : BaseViewHolder(view) {

    fun bind(movie: Movie) {
        iv_poster?.load(movie.getFullPathPosterUrl()) {
            val roundedSize = iv_poster.dpToPx(4).toFloat()
            transformations(RoundedCornersTransformation(roundedSize))
        }
        iv_backdrop?.load(movie.getFullPathBackdropUrl()) {
            placeholder(R.drawable.bg_loading_placeholder)
        }
        tv_title?.text = movie.title
        tv_genre?.text = movie.getListOfGenreNames()
        tv_runtime?.text = movie.getDurationText()
        tv_rating?.text = movie.rating.toString()
        tv_rating_count?.text =
            String.format(itemView.context.getString(R.string.vote_counts), movie.voteCount)
    }
}