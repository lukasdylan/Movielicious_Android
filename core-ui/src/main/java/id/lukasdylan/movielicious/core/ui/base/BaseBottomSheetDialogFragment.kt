package id.lukasdylan.movielicious.core.ui.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.lukasdylan.movielicious.core.ui.R

/**
 * Created by lukasdylan on 2020-02-09
 */
open class BaseBottomSheetDialogFragment(@LayoutRes private val layoutId: Int) :
    BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutId, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (requireDialog() as? BottomSheetDialog)?.dismissWithAnimation = true
    }
}