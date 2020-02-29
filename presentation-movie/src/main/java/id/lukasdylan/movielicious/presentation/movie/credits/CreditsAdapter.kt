package id.lukasdylan.movielicious.presentation.movie.credits

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.movielicious.core.ui.inflateView
import id.lukasdylan.movielicious.presentation.movie.R

/**
 * Created by lukasdylan on 2020-02-09
 */
class CreditsAdapter(private val data: Array<out Cast>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADER_VIEW_TYPE) {
            HeaderCreditsViewHolder(parent.inflateView(R.layout.item_credits_header))
        } else {
            CreditsViewHolder(parent.inflateView(R.layout.item_movie_person_vertical))
        }
    }

    override fun getItemCount(): Int = data.size.plus(1)

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) HEADER_VIEW_TYPE else CREDIT_VIEW_TYPE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CreditsViewHolder) {
            val selectedData = data[position - 1]
            holder.bind(selectedData)
        }
    }

    companion object {
        private const val HEADER_VIEW_TYPE = 0
        private const val CREDIT_VIEW_TYPE = 1
    }
}