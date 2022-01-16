package org.android.reminiscencewinter.presentation.memory.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.reminiscencewinter.R
import org.android.reminiscencewinter.databinding.FragmentSharingBottomSheetBinding
import org.android.reminiscencewinter.presentation.util.AutoClearedValue

@AndroidEntryPoint
class SharingBottomSheetFragment() : BottomSheetDialogFragment() {
    private var binding by AutoClearedValue<FragmentSharingBottomSheetBinding>()

    override fun getTheme() = R.style.BottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSharingBottomSheetBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        shareLink()
    }

    private fun shareLink(){
        with(binding){
            buttonInstagram.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"))
                startActivity(intent)
            }
            buttonSms.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT,"사진 전송하기")
                startActivity(intent)
            }
            buttonKakao.setOnClickListener {
                Toast.makeText(context, "카카오톡 공유 기능은 준비중 입니다:) ",Toast.LENGTH_SHORT).show()
            }
        }
    }
}