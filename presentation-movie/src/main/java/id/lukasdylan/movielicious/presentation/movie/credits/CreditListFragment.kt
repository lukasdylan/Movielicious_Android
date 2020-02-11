package id.lukasdylan.movielicious.presentation.movie.credits

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import id.lukasdylan.movielicious.core.ui.base.BaseBottomSheetDialogFragment
import id.lukasdylan.movielicious.presentation.movie.R
import kotlinx.android.synthetic.main.fragment_credit_list.*

/**
 * Created by lukasdylan on 2020-02-09
 */
class CreditListFragment : BaseBottomSheetDialogFragment(R.layout.fragment_credit_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val creditListFragmentArgs by navArgs<CreditListFragmentArgs>()
        val data = creditListFragmentArgs.creditList.orEmpty()
        rv_cast_crew?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CreditsAdapter(data)
        }
    }
}