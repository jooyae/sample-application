package org.android.reminiscencewinter.presentation.album.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.databinding.FragmentAlbumBinding
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.presentation.album.adapter.AlbumAdapter
import org.android.reminiscencewinter.presentation.album.viewmodel.AlbumViewModel
import org.android.reminiscencewinter.presentation.util.AutoClearedValue
import org.android.reminiscencewinter.presentation.util.RecyclerviewSpacingDecoration

@AndroidEntryPoint
class AlbumFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentAlbumBinding>()
    private val viewModel : AlbumViewModel by viewModels()

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
        binding.viewModel = viewModel
        loadSpecailMoment()
    }

    private fun loadSpecailMoment(){
        binding.recyclerviewSearchPhoto.run {
            adapter = AlbumAdapter(object : AlbumAdapter.OnItemClickListener{
                override fun itemClick(view: View, photoEntity: PhotoEntity) {

                }
            })
            addItemDecoration(RecyclerviewSpacingDecoration(10,1))
            viewModel.pictures.observe(viewLifecycleOwner){
                (adapter as AlbumAdapter).submitData(lifecycle, it)
            }
        }
    }


}