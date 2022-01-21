package org.android.reminiscencewinter.presentation.album.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.reminiscencewinter.BR
import org.android.reminiscencewinter.databinding.ItemPhotoBinding
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.presentation.util.DiffCallback

class AlbumAdapter(val listener : OnItemClickListener) : PagingDataAdapter<PhotoEntity, AlbumAdapter.AlbumViewHolder>(
    DiffCallback<PhotoEntity>()
) {
    interface OnItemClickListener{
        fun itemClick(view: View, photoEntity: PhotoEntity)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }
    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run { setVariable(BR.data, item) }
        holder.binding.root.setOnClickListener {  }
    }
    class AlbumViewHolder(val binding : ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)
}