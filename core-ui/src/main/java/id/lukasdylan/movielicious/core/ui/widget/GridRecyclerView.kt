package id.lukasdylan.movielicious.core.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.GridLayoutAnimationController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by lukasdylan on 2020-02-01
 */
class GridRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RecyclerView(context, attrs, defStyle) {

    override fun attachLayoutAnimationParameters(
        child: View?, params: ViewGroup.LayoutParams,
        index: Int, count: Int
    ) {
        val layoutManager = layoutManager
        if (adapter != null && layoutManager is GridLayoutManager) {
            val animationParams = params.layoutAnimationParameters
                    as? GridLayoutAnimationController.AnimationParameters
                ?: GridLayoutAnimationController.AnimationParameters()
            params.layoutAnimationParameters = animationParams

            val columns = layoutManager.spanCount
            animationParams.count = count
            animationParams.index = index
            animationParams.columnsCount = columns
            animationParams.rowsCount = count / columns

            val invertedIndex = count - 1 - index
            animationParams.column = columns - 1 - (invertedIndex % columns)
            animationParams.row = animationParams.rowsCount - 1 - invertedIndex / columns
        } else { // Proceed as normal if using another type of LayoutManager
            super.attachLayoutAnimationParameters(child, params, index, count)
        }
    }
}