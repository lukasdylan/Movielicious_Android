package id.lukasdylan.movielicious.presentation.movie.detail

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import id.lukasdylan.movielicious.core.utils.ViewModelKey

/**
 * Created by lukasdylan on 2020-02-01
 */
@Module
abstract class DetailMovieModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailMovieViewModel::class)
    abstract fun bindDetailMovieViewModel(viewModel: DetailMovieViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeDetailMovieFragmentV2(): DetailMovieFragment
}