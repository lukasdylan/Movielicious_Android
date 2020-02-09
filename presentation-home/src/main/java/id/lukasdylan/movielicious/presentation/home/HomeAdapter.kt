package id.lukasdylan.movielicious.presentation.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.ui.inflateView

/**
 * Created by lukasdylan on 2020-02-01
 */
class HomeAdapter : ListAdapter<Movie, HomeViewHolder>(MovieDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(parent.inflateView(R.layout.item_home_discover))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        getItem(position)?.let(holder::bind)
    }

    object MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}