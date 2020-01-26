package id.lukasdylan.movielicious.test

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by lukasdylan on 2020-01-25
 */
@Module
abstract class TestActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeTestActivity(): TestActivity
}