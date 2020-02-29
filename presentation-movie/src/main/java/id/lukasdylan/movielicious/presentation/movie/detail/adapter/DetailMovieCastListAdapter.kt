package id.lukasdylan.movielicious.presentation.movie.detail.adapter

import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.movielicious.core.ui.inflateView
import id.lukasdylan.movielicious.presentation.movie.R
import id.lukasdylan.movielicious.presentation.movie.detail.DetailMovieFragmentDirections
import id.lukasdylan.movielicious.presentation.movie.detail.viewholder.PersonMoreViewHolder
import id.lukasdylan.movielicious.presentation.movie.detail.viewholder.PersonViewHolder

/**
 * Created by lukasdylan on 2020-02-11
 */
class DetailMovieCastListAdapter(private val data: List<Cast>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == SEE_MORE_VIEW_TYPE) {
            PersonMoreViewHolder(
                parent.inflateView(R.layout.item_movie_person_more)
            ) {
                val directions =
                    DetailMovieFragmentDirections.openCreditListScreen(
                        data.toTypedArray()
                    )
                it.findNavController().navigate(directions)
            }
        } else {
            PersonViewHolder(
                parent.inflateView(R.layout.item_movie_person)
            )
        }
    }

    override fun getItemCount(): Int {
        return if (data.size > MAX_PERSON_SHOWN) {
            MAX_PERSON_SHOWN.plus(1)
        } else {
            data.size
        }
    }

    override fun getItemViewType(position: Int): Int {
        val isHadSeeMoreView = data.size > MAX_PERSON_SHOWN
        if (isHadSeeMoreView) {
            return if (position == MAX_PERSON_SHOWN) {
                SEE_MORE_VIEW_TYPE
            } else {
                PERSON_VIEW_TYPE
            }
        }
        return PERSON_VIEW_TYPE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PersonViewHolder) {
            val selectedData = data[position]
            holder.bind(selectedData)
        } else if (holder is PersonMoreViewHolder) {
            holder.bind(data.size - MAX_PERSON_SHOWN)
        }
    }

    companion object {
        private const val PERSON_VIEW_TYPE = 0
        private const val SEE_MORE_VIEW_TYPE = 1

        private const val MAX_PERSON_SHOWN = 7
    }
}