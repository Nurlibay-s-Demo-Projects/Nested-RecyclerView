package uz.nurlibaydev.rvinnerrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.nurlibaydev.rvinnerrv.databinding.ParentItemBinding

/**
 *  Created by Nurlibay Koshkinbaev on 25/03/2023 21:19
 */

class ParentAdapter : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    var list = mutableListOf<Parent>()
        set(value) {
            field = value
        }

    private val childAdapter = ChildAdapter()

    inner class ParentViewHolder(private val binding: ParentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(parent: Parent) {
            binding.apply {
                parentTitle.text = parent.title
                childRecyclerview.adapter = childAdapter
                childAdapter.movies = parent.movieList
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return ParentViewHolder(ParentItemBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        holder.bind(list[position])
    }
}