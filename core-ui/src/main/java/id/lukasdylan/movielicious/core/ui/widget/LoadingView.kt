package id.lukasdylan.movielicious.core.ui.widget

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import id.lukasdylan.movielicious.core.ui.R
import kotlinx.android.synthetic.main.layout_loading_full.view.*

/**
 * Created by lukasdylan on 2020-02-11
 */
class LoadingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.layout_loading_full, this)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingView)
        setLoadingMessage(typedArray.getString(R.styleable.LoadingView_loadingMessage).orEmpty())
        typedArray.recycle()
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun setLoadingMessage(message: String) {
        tv_loading_message?.text = message
    }
}