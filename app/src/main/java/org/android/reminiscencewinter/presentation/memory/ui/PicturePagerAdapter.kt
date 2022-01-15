package org.android.reminiscencewinter.presentation.memory.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.reminiscencewinter.BR
import org.android.reminiscencewinter.databinding.ItemPhotoBinding
import org.android.reminiscencewinter.domain.model.AlbumEntity
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.presentation.util.DiffCallback

class PicturePagerAdapter(private val listener : PictureInfoInterface)  : PagingDataAdapter<PhotoEntity, PicturePagerAdapter.PicturePagerViewHolder>(
    DiffCallback<PhotoEntity>()
){
    interface PictureInfoInterface{
        fun showDetail(photoEntity: PhotoEntity)
    }
    override fun onBindViewHolder(holder: PicturePagerViewHolder, position: Int) {
        val picture = getItem(position)
        holder.binding.setVariable(BR.memory, picture)
        holder.binding.imageviewPhoto.setOnClickListener {
            if (picture != null) {
                listener.showDetail(picture)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicturePagerViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PicturePagerViewHolder(binding)
    }

    class PicturePagerViewHolder(val binding: ItemPhotoBinding): RecyclerView.ViewHolder(binding.root)
}