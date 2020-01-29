package id.lukasdylan.movielicious.test

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.R
import id.lukasdylan.movielicious.core.extension.onContentChanged
import kotlinx.android.synthetic.main.activity_test.*
import javax.inject.Inject

/**
 * Created by lukasdylan on 2020-01-25
 */
class TestActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

//    @Inject
//    lateinit var dispatcherProvider: DispatcherProvider

    private val testAdapter = TestAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        rv_test?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = testAdapter
        }
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
        testAdapter.setData(data)
    }
}
