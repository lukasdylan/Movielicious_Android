package id.lukasdylan.movielicious.core.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.CacheImplementation
import kotlinx.android.extensions.ContainerOptions
import kotlinx.android.extensions.LayoutContainer

/**
 * Created by lukasdylan on 2020-02-09
 */
@ContainerOptions(CacheImplementation.SPARSE_ARRAY)
abstract class BaseViewHolder<T>(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    abstract fun bind(item: T)
}