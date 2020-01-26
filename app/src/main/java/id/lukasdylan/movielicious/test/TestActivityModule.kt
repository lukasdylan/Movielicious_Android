package id.lukasdylan.movielicious.test

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import id.lukasdylan.movielicious.core.utils.ViewModelKey

/**
 * Created by lukasdylan on 2020-01-25
 */
@Module
abstract class TestActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel::class)
    abstract fun bindUserViewModel(testViewModel: TestViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeTestActivity(): TestActivity
}