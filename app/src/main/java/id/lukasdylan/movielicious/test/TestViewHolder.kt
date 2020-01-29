package id.lukasdylan.movielicious.test

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import id.lukasdylan.domain.movie.model.Movie
import kotlinx.android.extensions.CacheImplementation
import kotlinx.android.extensions.ContainerOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_test.*

/**
 * Created by lukasdylan on 2020-01-28
 */
@ContainerOptions(CacheImplementation.SPARSE_ARRAY)
class TestViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(item: Movie) {
        tv_title?.text = item.title
    }
}