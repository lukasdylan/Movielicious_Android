package id.lukasdylan.movielicious.presentation.movie

import android.content.Context
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import coil.transform.RoundedCornersTransformation
import dagger.android.support.AndroidSupportInjection
import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.extension.onContentChanged
import id.lukasdylan.movielicious.core.ui.dpToPx
import id.lukasdylan.movielicious.core.ui.hide
import id.lukasdylan.movielicious.core.ui.show
import id.lukasdylan.movielicious.core.ui.widget.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_detail_movie.*
import javax.inject.Inject

/**
 * Created by lukasdylan on 2020-02-04
 */
class DetailMovieFragment : Fragment(R.layout.fragment_detail_movie) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val detailMovieFragmentArgs by navArgs<DetailMovieFragmentArgs>()

    private val viewModel: DetailMovieViewModel by viewModels(factoryProducer = { factory })

    private val castAdapter = MovieCastAdapter()

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.execute(DetailMovieAction.LoadMovieData(detailMovieFragmentArgs.movieId))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner) {
            it.movieData.onContentChanged(this::renderDetailMovie)
            it.castList.onContentChanged(this::renderMovieCast)
            showLoadingLayout(it.isLoading)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_cast_crew?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(GridSpacingItemDecoration(10, dpToPx(12), true))
            adapter = castAdapter
        }
    }

    private fun renderDetailMovie(movie: Movie) {
        iv_poster?.load(movie.posterUrl) {
            val roundedSize = iv_poster.dpToPx(4).toFloat()
            transformations(RoundedCornersTransformation(roundedSize))
        }
        iv_backdrop?.load(movie.backdropUrl) {
            placeholder(null)
        }
        tv_title?.text = movie.title
        tv_genre?.text = movie.getListOfGenreNames()
        tv_overview?.text = movie.overview
    }

    private fun renderMovieCast(data: List<Cast>) {
        castAdapter.submitList(data.take(10))
    }

    private fun showLoadingLayout(isLoading: Boolean) {
        TransitionManager.beginDelayedTransition(root_layout)
        if (isLoading) layout_loading?.show() else layout_loading?.hide()
    }
}