package id.lukasdylan.movielicious.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.R

/**
 * Created by lukasdylan on 2020-01-29
 */
class TestAdapter : RecyclerView.Adapter<TestViewHolder>() {

    private val data = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_test, parent, false)
        return TestViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun setData(data: List<Movie>) {
        val diffResult = DiffUtil.calculateDiff(diffCallback(this.data, data))
        this.data.clear()
        this.data.addAll(data)
        diffResult.dispatchUpdatesTo(this)
    }

    companion object {
        private fun diffCallback(oldList: List<Movie>, newList: List<Movie>) =
            object : DiffUtil.Callback() {
                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    return oldList[oldItemPosition].id == newList[newItemPosition].id
                }

                override fun getOldListSize(): Int = oldList.size

                override fun getNewListSize(): Int = newList.size

                override fun areContentsTheSame(
                    oldItemPosition: Int,
                    newItemPosition: Int
                ): Boolean {
                    return oldList[oldItemPosition] == newList[newItemPosition]
                }
            }
    }

}