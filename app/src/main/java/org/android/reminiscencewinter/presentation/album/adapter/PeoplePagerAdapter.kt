package org.android.reminiscencewinter.presentation.album.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.reminiscencewinter.BR
import org.android.reminiscencewinter.databinding.ItemPeopleBinding
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.presentation.util.DiffCallback

class PeoplePagerAdapter() : PagingDataAdapter<PhotoEntity, PeoplePagerAdapter.PeopleViewHolder>(
    DiffCallback<PhotoEntity>()
){
    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run { setVariable(BR.data, item) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = ItemPeopleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding)
    }
    class PeopleViewHolder(val binding : ItemPeopleBinding) : RecyclerView.ViewHolder(binding.root)
}