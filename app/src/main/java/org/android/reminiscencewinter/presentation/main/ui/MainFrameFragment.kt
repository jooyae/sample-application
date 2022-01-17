package org.android.reminiscencewinter.presentation.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.*
import org.android.reminiscencewinter.presentation.album.AlbumFragment
import org.android.reminiscencewinter.databinding.FragmentMainFrameBinding
import org.android.reminiscencewinter.presentation.main.viewmodel.MainFrameViewModel
import org.android.reminiscencewinter.presentation.memory.ui.fragment.MemoryFragment
import org.android.reminiscencewinter.presentation.storage.ui.StorageFragment
import org.android.reminiscencewinter.presentation.story.StoryFragment
import org.android.reminiscencewinter.presentation.util.AutoClearedValue

@AndroidEntryPoint
class MainFrameFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentMainFrameBinding>()
    private val viewModel: MainFrameViewModel by activityViewModels()

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
        observeViewModel()
        initViewPager()
        configureBottomNavigation()
    }

    private fun observeViewModel() {
        viewModel.pageIndex.observe(viewLifecycleOwner) { pageIndex ->
            binding.viewpagerMainFrame.currentItem = pageIndex
            selectBottomNavigationMenu(pageIndex)
        }
    }

    private fun selectBottomNavigationMenu(pageIndex: Int) {
        binding.bottomNavigation.selectedItemId = when (pageIndex) {
            0 -> R.id.memoryFragment
            1 -> R.id.storageFragment
            2 -> R.id.albumFragment
            3 -> R.id.storyFragment
            else -> throw RuntimeException("Bottom Navigation Load Error")
        }
    }

    private fun initViewPager() = binding.viewpagerMainFrame.run {
        isUserInputEnabled = false
        offscreenPageLimit = 4
        adapter = MainFrameAdapter(this@MainFrameFragment)
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.changePageIdx(position)
            }
        })
    }

    private fun configureBottomNavigation() = binding.bottomNavigation.run {
        setOnItemSelectedListener { item->
            viewModel.changePageIdx(
                when(item.itemId){
                    R.id.memoryFragment -> 0
                    R.id.storageFragment -> 1
                    R.id.albumFragment -> 2
                    R.id.storyFragment -> 3
                    else -> throw java.lang.RuntimeException("Bottom Navigation Item Error")
                }
            )
            true
        }
    }


    class MainFrameAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount() = 4
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> MemoryFragment()
                1 -> StorageFragment()
                2 -> AlbumFragment()
                3 -> StoryFragment()
                else -> throw RuntimeException("Fragment Load Error")
            }
        }
    }
}