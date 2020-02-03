package id.lukasdylan.movielicious.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import dagger.android.support.DaggerFragment
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.extension.onContentChanged
import id.lukasdylan.movielicious.core.ui.dpToPx
import id.lukasdylan.movielicious.core.ui.widget.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val homeViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    private val homeAdapter by lazy {
        HomeAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.execute(HomeAction.LoadDiscoverList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_home?.apply {
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(GridSpacingItemDecoration(2, dpToPx(24), true))
            adapter = homeAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel.viewState.observe(viewLifecycleOwner) {
            it.errorMessage.onContentChanged(this::showToast)
            it.data.onContentChanged(this::printData)
            it.loadingState.onContentChanged(this::showLoading)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun printData(data: List<Movie>) {
        homeAdapter.submitList(data)
        rv_home?.scheduleLayoutAnimation()
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) pb_loading?.show() else pb_loading?.hide()
    }
}
