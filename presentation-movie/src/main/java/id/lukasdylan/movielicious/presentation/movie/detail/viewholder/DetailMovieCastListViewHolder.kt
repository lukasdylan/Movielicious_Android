package id.lukasdylan.movielicious.presentation.movie.detail.viewholder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.movielicious.core.ui.base.BaseViewHolder
import id.lukasdylan.movielicious.presentation.movie.detail.adapter.DetailMovieCastListAdapter
import kotlinx.android.synthetic.main.item_list_cast_detail_movie.*

/**
 * Created by lukasdylan on 2020-02-11
 */
class DetailMovieCastListViewHolder(view: View, recycledViewPool: RecyclerView.RecycledViewPool) :
    BaseViewHolder(view) {

    init {
        rv_cast_crew?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            setRecycledViewPool(recycledViewPool)
        }
    }

    fun bind(data: List<Cast>) {
        val adapter = DetailMovieCastListAdapter(data)
        rv_cast_crew?.adapter = adapter
    }
}