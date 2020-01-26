package id.lukasdylan.movielicious.test

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import id.lukasdylan.data.movie.datamanager.MovieDataManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by lukasdylan on 2020-01-25
 */
class TestActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var movieDataManager: MovieDataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch(Dispatchers.IO) {
            movieDataManager.loadDiscoverList()
        }
    }
}