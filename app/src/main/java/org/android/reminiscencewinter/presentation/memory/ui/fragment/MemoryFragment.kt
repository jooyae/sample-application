package org.android.reminiscencewinter.presentation.memory.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.databinding.FragmentMemoryBinding
import org.android.reminiscencewinter.domain.model.AlbumEntity
import org.android.reminiscencewinter.presentation.main.ui.MainFrameFragmentDirections
import org.android.reminiscencewinter.presentation.memory.ui.adapter.MemoryAdapter
import org.android.reminiscencewinter.presentation.memory.viewmodel.MemoryViewModel
import org.android.reminiscencewinter.presentation.util.AutoClearedValue
import org.android.reminiscencewinter.presentation.util.RecyclerviewSpacingDecoration

@AndroidEntryPoint
class MemoryFragment : Fragment(){
    private var binding by AutoClearedValue<FragmentMemoryBinding>()
    private val viewModel by viewModels<MemoryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentMemoryBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        fetchRepresentativeAlbum()
    }

    private fun fetchRepresentativeAlbum(){
        binding.recyclerviewMemory.run {
            adapter = MemoryAdapter(object : MemoryAdapter.OnItemClickListener{
                override fun itemClick(view: View, albumEntity: AlbumEntity) {
                    val action = MainFrameFragmentDirections.actionMainFrameFragmentToMemoryDetailFragment(albumEntity)
                    findNavController().navigate(action)
                }
            })
            addItemDecoration(RecyclerviewSpacingDecoration(15,2))
            viewModel.albums.observe(viewLifecycleOwner){
                (adapter as MemoryAdapter).submitList(it)
            }
        }
    }


}