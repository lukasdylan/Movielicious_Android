package id.lukasdylan.movielicious.presentation.home

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
abstract class HomeModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
}