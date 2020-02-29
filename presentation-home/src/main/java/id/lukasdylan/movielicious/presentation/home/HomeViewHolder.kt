package id.lukasdylan.movielicious.presentation.home

import android.net.Uri
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import coil.api.load
import coil.transform.RoundedCornersTransformation
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.ui.BuildConfig
import id.lukasdylan.movielicious.core.ui.base.BaseViewHolder
import id.lukasdylan.movielicious.core.ui.dpToPx
import id.lukasdylan.movielicious.core.ui.slideLeftRightAnim
import kotlinx.android.synthetic.main.item_home_discover.*

/**
 * Created by lukasdylan on 2020-02-01
 */
class HomeViewHolder(view: View) : BaseViewHolder<Movie>(view) {

    private val roundedSize = containerView.dpToPx(6).toFloat()

    private val navOptions by lazy {
        navOptions { slideLeftRightAnim() }
    }

    override fun bind(item: Movie) {
        tv_title?.text = item.title
        iv_poster?.load(item.getFullPathPosterUrl()) {
            transformations(RoundedCornersTransformation(roundedSize))
        }

        root_layout?.setOnClickListener {
            val uri = Uri.parse("${BuildConfig.MOVIELICIOUS_HOSTNAME}detailmovie2/${item.id}")
            it?.findNavController()?.navigate(uri, navOptions)
        }
    }
}