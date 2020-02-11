package id.lukasdylan.movielicious.presentation.movie.detail.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.ui.inflateView
import id.lukasdylan.movielicious.presentation.movie.*
import id.lukasdylan.movielicious.presentation.movie.detail.DetailMovieSection
import id.lukasdylan.movielicious.presentation.movie.detail.MovieCastListSection
import id.lukasdylan.movielicious.presentation.movie.detail.MovieHeaderSection
import id.lukasdylan.movielicious.presentation.movie.detail.MovieOverviewSection
import id.lukasdylan.movielicious.presentation.movie.detail.viewholder.DetailMovieCastListViewHolder
import id.lukasdylan.movielicious.presentation.movie.detail.viewholder.DetailMovieHeaderViewHolder
import id.lukasdylan.movielicious.presentation.movie.detail.viewholder.DetailMovieOverviewViewHolder
import java.lang.IllegalArgumentException

/**
 * Created by lukasdylan on 2020-02-11
 */
class DetailMovieAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val sectionList = DetailMovieSection.getLayoutStructure()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DetailMovieSection.MOVIE_HEADER_VIEW_TYPE -> {
                DetailMovieHeaderViewHolder(
                    parent.inflateView(R.layout.item_header_detail_movie)
                )
            }
            DetailMovieSection.MOVIE_OVERVIEW_VIEW_TYPE -> {
                DetailMovieOverviewViewHolder(
                    parent.inflateView(R.layout.item_overview_detail_movie)
                )
            }
            DetailMovieSection.MOVIE_CAST_LIST_VIEW_TYPE -> {
                DetailMovieCastListViewHolder(
                    parent.inflateView(R.layout.item_list_cast_detail_movie),
                    RecyclerView.RecycledViewPool()
                )
            }
            else -> throw IllegalArgumentException("Unknown View Type")
        }
    }

    override fun getItemCount(): Int = sectionList.size

    override fun getItemViewType(position: Int): Int = sectionList[position].viewType

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DetailMovieHeaderViewHolder -> {
                val selectedData = sectionList[position] as MovieHeaderSection
                selectedData.movie?.let { holder.bind(it) }
            }
            is DetailMovieOverviewViewHolder -> {
                val selectedData = sectionList[position] as MovieOverviewSection
                holder.bind(selectedData.overview.orEmpty())
            }
            is DetailMovieCastListViewHolder -> {
                val selectedData = sectionList[position] as MovieCastListSection
                selectedData.castList?.let { holder.bind(it) }
            }
        }
    }

    fun onUpdateMovieData(movie: Movie) {
        getSectionPosition(DetailMovieSection.MOVIE_HEADER_VIEW_TYPE)?.let {
            sectionList[it] = DetailMovieSection.updateMovieHeaderData(movie)
            notifyItemChanged(it)
        }
        getSectionPosition(DetailMovieSection.MOVIE_OVERVIEW_VIEW_TYPE)?.let {
            sectionList[it] = DetailMovieSection.updateMovieOverviewData(movie.overview)
            notifyItemChanged(it)
        }
    }

    fun onUpdateCastData(data: List<Cast>) {
        getSectionPosition(DetailMovieSection.MOVIE_CAST_LIST_VIEW_TYPE)?.let {
            sectionList[it] = DetailMovieSection.updateMovieCastListData(data)
            notifyItemChanged(it)
        }
    }

    private fun getSectionPosition(type: Int): Int? =
        sectionList.indexOf(sectionList.find { it.viewType == type }).takeIf { it >= 0 }

}