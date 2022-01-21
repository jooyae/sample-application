package org.android.reminiscencewinter.presentation.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.databinding.FragmentAlbumBinding
import org.android.reminiscencewinter.presentation.util.AutoClearedValue

@AndroidEntryPoint
class AlbumFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentAlbumBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentAlbumBinding.inflate(inflater, container, false)?.let{
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }


}