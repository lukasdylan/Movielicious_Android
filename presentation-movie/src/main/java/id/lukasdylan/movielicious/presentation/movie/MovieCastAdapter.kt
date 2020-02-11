package id.lukasdylan.movielicious.presentation.movie

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.movielicious.core.ui.inflateView
import id.lukasdylan.movielicious.presentation.movie.utils.CastDiffCallback

/**
 * Created by lukasdylan on 2020-02-08
 */
class MovieCastAdapter : ListAdapter<Cast, MovieCreditsViewHolder>(CastDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCreditsViewHolder {
        return MovieCreditsViewHolder(parent.inflateView(R.layout.item_movie_person))
    }

    override fun onBindViewHolder(holder: MovieCreditsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(
                name = it.name,
                description = it.characterName,
                profileUrl = it.getFullPathProfileUrl()
            )
        }
    }
}