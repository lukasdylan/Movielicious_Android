package id.lukasdylan.movielicious.test

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import dagger.android.support.DaggerAppCompatActivity
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.extension.onContentChanged
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by lukasdylan on 2020-01-25
 */
class TestActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val testViewModel = ViewModelProvider(this, viewModelFactory).get(TestViewModel::class.java)
        testViewModel.viewState.observe(this) {
            it.errorMessage.onContentChanged(this::showToast)
            it.data.onContentChanged(this::printData)
        }
        testViewModel.execute(TestAction.LoadDiscoverList)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun printData(data: List<Movie>) {
        showToast("Data size = ${data.size}")
        data.forEach {
            Timber.d(it.toString())
        }
    }
}
