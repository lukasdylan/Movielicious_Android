package id.lukasdylan.movielicious.presentation.movie.detail.viewholder

import android.view.View
import id.lukasdylan.movielicious.core.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_movie_person_more.*

/**
 * Created by lukasdylan on 2020-02-08
 */
class PersonMoreViewHolder(view: View, private val listener: (View) -> Unit) :
    BaseViewHolder<Int>(view) {

    init {
        root_layout_cast_more?.setOnClickListener { listener.invoke(it) }
    }

    override fun bind(item: Int) {
        tv_left_count?.text = "+$item"
    }
}