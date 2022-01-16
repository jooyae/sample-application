package org.android.reminiscencewinter.presentation.memory.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.R
import org.android.reminiscencewinter.databinding.FragmentSharingBottomSheetBinding
import org.android.reminiscencewinter.presentation.util.AutoClearedValue

@AndroidEntryPoint
class SharingBottomSheetFragment() : BottomSheetDialogFragment() {
    private var binding by AutoClearedValue<FragmentSharingBottomSheetBinding>()

    override fun getTheme() = R.style.BottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSharingBottomSheetBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }
}