package id.lukasdylan.movielicious.presentation.movie.detail

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import dagger.android.support.AndroidSupportInjection
import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.extension.onContentChanged
import id.lukasdylan.movielicious.core.ui.hide
import id.lukasdylan.movielicious.core.ui.show
import id.lukasdylan.movielicious.presentation.movie.R
import id.lukasdylan.movielicious.presentation.movie.detail.adapter.DetailMovieAdapter
import kotlinx.android.synthetic.main.fragment_detail_movie_v2.*
import javax.inject.Inject

/**
 * Created by lukasdylan on 2020-02-04
 */
class DetailMovieFragment : Fragment(R.layout.fragment_detail_movie_v2) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: DetailMovieViewModel by viewModels(factoryProducer = { factory })

    private val detailMovieAdapter by lazy {
        DetailMovieAdapter()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailMovieFragmentArgs by navArgs<DetailMovieFragmentArgs>()
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
        rv_detail_movie?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                ContextCompat.getDrawable(context, R.drawable.bg_line_separator)?.let { it ->
                    setDrawable(it)
                }
            })
            adapter = detailMovieAdapter
        }
    }

    private fun showLoadingLayout(isLoading: Boolean) {
        TransitionManager.beginDelayedTransition(root_layout, AutoTransition().apply {
            excludeTarget(rv_detail_movie, true)
        })
        if (isLoading) loading_view?.show() else loading_view?.hide()
    }

    private fun renderDetailMovie(movie: Movie) {
        detailMovieAdapter.onUpdateMovieData(movie)
    }

    private fun renderMovieCast(data: List<Cast>) {
        detailMovieAdapter.onUpdateCastData(data)
    }
}