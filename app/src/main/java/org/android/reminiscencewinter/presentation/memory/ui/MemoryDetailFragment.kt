package org.android.reminiscencewinter.presentation.memory.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.databinding.FragmentMemoryBinding
import org.android.reminiscencewinter.presentation.memory.viewmodel.AlbumViewModel
import org.android.reminiscencewinter.presentation.util.AutoClearedValue

@AndroidEntryPoint
class MemoryDetailFragment  : Fragment(){
    private var binding by AutoClearedValue<FragmentMemoryBinding>()
    private val viewModel : AlbumViewModel by viewModels()
    private val args : MemoryDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?= FragmentMemoryBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
//        viewModel.updateAlbumInfo(args.photoInfo)
//        loadPictures()
//        loadPhotos()
    }

//    private fun loadPictures() {
//        viewModel.albumInfo.observe(viewLifecycleOwner) { album ->
//            if(album != null) {
//                viewModel.getPictures()
//            }
//        }
//    }

//    private fun loadPhotos(){ viewModel.photos.observe(viewLifecycleOwner) { if(it != null){ viewModel.getPictures() } } }

}