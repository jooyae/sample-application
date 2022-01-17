package org.android.reminiscencewinter.presentation.storage.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.reminiscencewinter.BR
import org.android.reminiscencewinter.databinding.ItemStorageBinding
import org.android.reminiscencewinter.domain.model.StorageEntity
import org.android.reminiscencewinter.presentation.util.DiffCallback

class StorageAdapter() : PagingDataAdapter<StorageEntity, StorageAdapter.StorageViewHolder>(
    DiffCallback<StorageEntity>()
){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StorageViewHolder {
        val binding = ItemStorageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StorageViewHolder(binding)
    }
    override fun onBindViewHolder(holder: StorageViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run { setVariable(BR.data, item) }
    }
    class StorageViewHolder(val binding : ItemStorageBinding) :
        RecyclerView.ViewHolder(binding.root)
}