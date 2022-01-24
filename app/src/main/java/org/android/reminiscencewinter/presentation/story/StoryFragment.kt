package org.android.reminiscencewinter.presentation.story

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.databinding.FragmentStoryBinding
import org.android.reminiscencewinter.presentation.util.AutoClearedValue
import java.io.File

@AndroidEntryPoint
class StoryFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentStoryBinding>()
    private lateinit var pictureUri: Uri

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentStoryBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        loadCamera()
        openGallery()
    }
    private fun loadCamera(){
        binding.buttonCamera.setOnClickListener {
            requestCameraPermission.launch(PERMISSION_REQUESTED)
        }
    }

    private fun openGallery(){
        binding.buttonGallery.setOnClickListener {
            requestGalleryPermission.launch(PERMISSION_REQUESTED)
        }
    }

    private val requestCameraPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if (it.values.filter { it == false }.count() != 0) {
                Toast.makeText(requireContext(), "권한을 모두 허용해주세요", Toast.LENGTH_SHORT).show()
            } else {
                takePicture()
            }
        }

    private val requestGalleryPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if (it.values.filter { allowed -> allowed == false }.count() != 0) {
                Toast.makeText(requireContext(), "권한을 모두 허용해주세요", Toast.LENGTH_SHORT).show()
            } else {
                galleryActivityLauncher.launch("image/*")
            }
        }

    private val galleryActivityLauncher =
        registerForActivityResult(ActivityResultContracts.GetMultipleContents()) { imageList ->
            imageList.forEach {
            }
        }

    private fun takePicture() {
        val photoFile = File.createTempFile(
            "IMG_",
            ".jpg",
            requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        )
        pictureUri = FileProvider.getUriForFile(
            requireContext(),
            "${requireContext().packageName}.provider",
            photoFile
        )
        cameraActivityLauncher.launch(pictureUri)
    }

    private val cameraActivityLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSaved ->
            if (isSaved) {
            }
        }

    companion object {
        const val PERMISSION_CAMERA = Manifest.permission.CAMERA
        const val PERMISSION_WRITE_EXTERNAL_STORAGE =
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        const val PERMISSION_READ_EXTERNAL_STORAGE =
            android.Manifest.permission.READ_EXTERNAL_STORAGE

        val PERMISSION_REQUESTED = arrayOf(
            PERMISSION_CAMERA,
            PERMISSION_WRITE_EXTERNAL_STORAGE,
            PERMISSION_READ_EXTERNAL_STORAGE
        )
    }
}