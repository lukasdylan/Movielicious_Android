package id.lukasdylan.movielicious.core.base

import androidx.fragment.app.Fragment

/**
 * Created by lukasdylan on 2020-01-23
 */
interface Navigator {
    fun navigateFrom(fragment: Fragment)
}