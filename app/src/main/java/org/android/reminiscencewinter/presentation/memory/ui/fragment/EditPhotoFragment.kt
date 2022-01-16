package org.android.reminiscencewinter.presentation.memory.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.databinding.FragmentEditMemoryBinding
import org.android.reminiscencewinter.presentation.memory.viewmodel.EditPhotoViewModel
import org.android.reminiscencewinter.presentation.util.AutoClearedValue

@AndroidEntryPoint
class EditPhotoFragment : Fragment(){
    private var binding by AutoClearedValue<FragmentEditMemoryBinding>()
    private val viewModel : EditPhotoViewModel by viewModels()
    private val args : EditPhotoFragmentArgs by navArgs()

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
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        loadNavArgs()
        popBackStack()
        editPhoto()
        showSharingBottomSheet()
        showDeletePhotoDialog()
    }
    private fun loadNavArgs(){
        with(viewModel){
            transferPhotoUrl(args.albumInfo.photo)
            transferPhotoAuthor(args.albumInfo.author)
        }
    }
    private fun popBackStack(){
        binding.buttonBack.setOnClickListener { findNavController().popBackStack() }
    }
    private fun editPhoto(){
        with(binding){
            buttonEdit.setOnClickListener {
                binding.layoutEditor.isVisible = true
                changeSaturation()
                changeContrast()
            }
        }
    }

    private fun changeSaturation(){
        binding.seekbarBrightness.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                with(binding){
                    imageviewPhoto.saturation = (progress / 100.0f) * 2
                    textviewBrightnessCount.text = binding.imageviewPhoto.saturation.toString()
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun changeContrast(){
        binding.seekbarContrast.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                with(binding){
                    imageviewPhoto.contrast = (progress / 100.0f) * 2
                    textviewContrastCount.text = binding.imageviewPhoto.contrast.toString()
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
    private fun showSharingBottomSheet(){
        binding.buttonShare.setOnClickListener {
            val bottomSheetFragment = SharingBottomSheetFragment()
            bottomSheetFragment.show(childFragmentManager, "Show Sharing Bottom Sheet")
        }
    }

    private fun showDeletePhotoDialog(){
        binding.buttonDelete.setOnClickListener {
            val dialog = DeletePhotoDialog(object : DeletePhotoDialog.DeleteCallback {
                override fun deletePhoto() {
                    findNavController().previousBackStackEntry?.savedStateHandle?.set("DELETE_PHOTO", true)
                    findNavController().popBackStack()
                }
                override fun exit() {

                }
            })
            dialog.show(childFragmentManager,"삭제되었습니다.")
            }
        }
}

