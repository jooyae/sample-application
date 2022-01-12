package org.android.reminiscencewinter.presentation.memory.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.reminiscencewinter.BR
import org.android.reminiscencewinter.presentation.util.DiffCallback
import org.android.reminiscencewinter.databinding.ItemMemoryBinding
import org.android.reminiscencewinter.domain.entity.MemoryEntity

class MemoryAdapter(val listener : OnItemClickListener) : ListAdapter<MemoryEntity, MemoryAdapter.MemoryViewHolder>(
    DiffCallback<MemoryEntity>()
) {
    interface OnItemClickListener{
        fun itemClick(view : View, memoryEntity: MemoryEntity)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoryViewHolder {
        val binding = ItemMemoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemoryViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MemoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run { setVariable(BR.memory, item) }
        holder.binding.root.setOnClickListener { listener.itemClick(holder.binding.imageviewRepresentativePhoto, item) }
    }
    class MemoryViewHolder(val binding : ItemMemoryBinding) : RecyclerView.ViewHolder(binding.root)
}