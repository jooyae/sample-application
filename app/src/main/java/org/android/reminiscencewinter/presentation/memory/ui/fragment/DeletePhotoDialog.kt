package org.android.reminiscencewinter.presentation.memory.ui.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.R
import org.android.reminiscencewinter.databinding.DialogDeletePhotoBinding
import org.android.reminiscencewinter.presentation.util.AutoClearedValue


@AndroidEntryPoint
class DeletePhotoDialog(private val callback: DeleteCallback) :DialogFragment(){
    private var binding by AutoClearedValue<DialogDeletePhotoBinding>()

    interface DeleteCallback{
        fun deletePhoto()
        fun exit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogDeletePhotoBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawableResource(R.drawable.background_delete_dialog_rad20)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        dismissDialog()
        confirmDelete()
    }

    private fun dismissDialog(){
        with(binding){
            buttonDelete.setOnClickListener { dismiss() }
        }
    }

    private fun confirmDelete(){
        binding.buttonDelete.setOnClickListener {
            callback.deletePhoto()
            dismiss()
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        callback.exit()
    }

}