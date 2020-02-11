package id.lukasdylan.movielicious.presentation.movie.utils

import androidx.recyclerview.widget.DiffUtil
import id.lukasdylan.domain.movie.model.Cast

/**
 * Created by lukasdylan on 2020-02-11
 */
object CastDiffCallback : DiffUtil.ItemCallback<Cast>() {
    override fun areItemsTheSame(oldItem: Cast, newItem: Cast): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Cast, newItem: Cast): Boolean {
        return oldItem == newItem
    }
}