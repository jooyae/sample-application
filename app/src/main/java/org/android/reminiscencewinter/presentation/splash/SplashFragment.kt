package org.android.reminiscencewinter.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import org.android.reminiscencewinter.R
import org.android.reminiscencewinter.databinding.FragmentSplashBinding
import org.android.reminiscencewinter.presentation.util.AutoClearedValue
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class SplashFragment : Fragment(), CoroutineScope{
    private var binding by AutoClearedValue<FragmentSplashBinding>()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSplashBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        launchSplash()
    }

    private fun launchSplash(){
        launch {
            delay(2500)
            withContext(Dispatchers.Main){
                findNavController().navigate(R.id.action_splashFragment_to_mainFrameFragment)
            }
        }
    }

}