package org.android.reminiscencewinter.presentation.memory.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.databinding.FragmentMemoryDetailBinding
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.presentation.memory.ui.adapter.PicturePagerAdapter
import org.android.reminiscencewinter.presentation.memory.viewmodel.MemoryDetailViewModel
import org.android.reminiscencewinter.presentation.util.AutoClearedValue
import org.android.reminiscencewinter.presentation.util.RecyclerviewSpacingDecoration

@AndroidEntryPoint
class MemoryDetailFragment  : Fragment(){
    private var binding by AutoClearedValue<FragmentMemoryDetailBinding>()
    private val viewModel : MemoryDetailViewModel by viewModels()
    private val args : MemoryDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?= FragmentMemoryDetailBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.updateAlbumInfo(args.photoInfo)

        updateChanges()
        updatePhotos()
        loadAlbum()
    }

    private fun updatePhotos(){
        viewModel.albumInfo.observe(viewLifecycleOwner){ album ->
            if(album != null){ viewModel.getPhotos() }
        }
    }


    private fun loadAlbum(){
        binding.recyclerviewPictures.run{
            adapter = PicturePagerAdapter(object : PicturePagerAdapter.PictureInfoInterface{
                override fun showDetail(photoEntity: PhotoEntity) {
                    val action = MemoryDetailFragmentDirections.actionMemoryDetailFragmentToEditMemoryFragment(
                            photoEntity
                        )
                    findNavController().navigate(action)
                }
            })
            addItemDecoration(RecyclerviewSpacingDecoration(14,2))
            viewModel.pictures.observe(viewLifecycleOwner){
                (adapter as PicturePagerAdapter).submitData(lifecycle, it)
            }
        }
    }

    private fun updateChanges() {
        findNavController().currentBackStackEntry?.savedStateHandle?.let {
            it.getLiveData("DELETE_PHOTO", false).observe(viewLifecycleOwner) { isDeleted ->
                if (isDeleted) {
                    viewModel.deletePhoto()
                    it.set("DELETE_PHOTO", false)
                }
            }
        }
    }

}