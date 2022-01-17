package org.android.reminiscencewinter.presentation.storage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.databinding.FragmentStorageBinding
import org.android.reminiscencewinter.presentation.storage.viewmodel.StorageViewModel
import org.android.reminiscencewinter.presentation.util.AutoClearedValue
import org.android.reminiscencewinter.presentation.util.RecyclerviewSpacingDecoration

@AndroidEntryPoint
class StorageFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentStorageBinding>()
    private val viewModel: StorageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentStorageBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.getStorage()
        loadStorage()
    }

    private fun loadStorage() {
        binding.recyclerviewPhoto.run {
            adapter = StorageAdapter()
            addItemDecoration(RecyclerviewSpacingDecoration(10, 2))
            viewModel.storage.observe(viewLifecycleOwner)
            {
                (adapter as StorageAdapter).submitData(lifecycle, it)
            }
        }

    }

}