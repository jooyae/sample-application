package org.android.reminiscencewinter.presentation.memory.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.reminiscencewinter.BR
import org.android.reminiscencewinter.presentation.util.DiffCallback
import org.android.reminiscencewinter.databinding.ItemMemoryBinding
import org.android.reminiscencewinter.domain.model.MemoryEntity
import org.android.reminiscencewinter.domain.model.PhotoEntity

class MemoryAdapter(val listener : OnItemClickListener) : ListAdapter<PhotoEntity, MemoryAdapter.MemoryViewHolder>(
    DiffCallback<PhotoEntity>()
) {
    interface OnItemClickListener{
        fun itemClick(view: View, memoryEntity: MemoryEntity)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoryViewHolder {
        val binding = ItemMemoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemoryViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MemoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run { setVariable(BR.memory, item) }
        holder.binding.root.setOnClickListener {  }
    }
    class MemoryViewHolder(val binding : ItemMemoryBinding) : RecyclerView.ViewHolder(binding.root)
}