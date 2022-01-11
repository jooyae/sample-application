package org.android.reminiscencewinter.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.databinding.FragmentMainFrameBinding
import org.android.reminiscencewinter.util.AutoClearedValue

@AndroidEntryPoint
class MainFrameFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentMainFrameBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentMainFrameBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }
}