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
class DetailMovieHeaderViewHolder(view: View) : BaseViewHolder<Movie>(view) {

    override fun bind(item: Movie) {
        iv_poster?.load(item.getFullPathPosterUrl()) {
            val roundedSize = iv_poster.dpToPx(6).toFloat()
            transformations(RoundedCornersTransformation(roundedSize))
        }
        iv_backdrop?.load(item.getFullPathBackdropUrl()) {
            placeholder(R.drawable.bg_loading_placeholder)
        }
        tv_title?.text = item.title
        tv_genre?.text = item.getListOfGenreNames()
        tv_runtime?.text = item.getDurationText()
        tv_rating?.text = item.rating.toString()
        tv_rating_count?.text =
            String.format(itemView.context.getString(R.string.vote_counts), item.voteCount)
    }
}