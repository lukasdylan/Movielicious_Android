package id.lukasdylan.movielicious.presentation.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.ui.dpToPx
import kotlinx.android.extensions.CacheImplementation
import kotlinx.android.extensions.ContainerOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_home_discover.*

/**
 * Created by lukasdylan on 2020-02-01
 */
@ContainerOptions(CacheImplementation.SPARSE_ARRAY)
class HomeViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private val roundedSize = containerView.dpToPx(8).toFloat()

    fun bind(item: Movie) {
        tv_title?.text = item.title
        iv_poster?.load(item.posterUrl) {
            transformations(RoundedCornersTransformation(roundedSize))
        }
    }
}