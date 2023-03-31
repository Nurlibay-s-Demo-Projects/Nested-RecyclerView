package uz.nurlibaydev.rvinnerrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.nurlibaydev.rvinnerrv.databinding.ItemParentBinding

/**
 *  Created by Nurlibay Koshkinbaev on 25/03/2023 23:09
 */

class ParentAdapter : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    private val childAdapter = ChildAdapter()

    var list = mutableListOf<Parent>()
        set(value) {
            field = value
        }

    inner class ParentViewHolder(private val binding: ItemParentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(parent: Parent) {
            binding.apply {
                rvChild.adapter = childAdapter
                tvParentTitle.text = parent.title
                childAdapter.movies = parent.movies.toMutableList()

                layout.setOnClickListener {
                    itemClick.invoke(parent)
                }
            }
        }
    }

    private var itemClick: (Parent) -> Unit = {}
    fun setOnItemClickListener(block: (Parent) -> Unit) {
        itemClick = block
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return ParentViewHolder(ItemParentBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_parent, parent, false)))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        holder.bind(list[position])
    }
}