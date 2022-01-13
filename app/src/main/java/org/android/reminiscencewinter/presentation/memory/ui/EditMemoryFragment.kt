package org.android.reminiscencewinter.presentation.memory.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.databinding.FragmentEditMemoryBinding
import org.android.reminiscencewinter.presentation.memory.viewmodel.MemoryViewModel
import org.android.reminiscencewinter.presentation.util.AutoClearedValue

@AndroidEntryPoint
class EditMemoryFragment : Fragment(){
    private var binding by AutoClearedValue<FragmentEditMemoryBinding>()
    private val viewModel : MemoryViewModel by viewModels()
    private val args : EditMemoryFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentEditMemoryBinding.inflate(inflater, container, false)?.let{
        binding = it
        it.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.updatePhotos(args.photoInfo)
        loadPhotos()
        loadNavArgs()
        popBackStack()
    }
    private fun loadNavArgs(){
        with(viewModel){ args.photoInfo.thumbnail?.let { transferPhotoUrl(it.photo) } }
    }
    private fun loadPhotos(){
        viewModel.memory.observe(viewLifecycleOwner) { if(it != null){ viewModel.getPictures() } }
    }
    private fun popBackStack(){
        binding.buttonBack.setOnClickListener { findNavController().popBackStack() }
    }


}