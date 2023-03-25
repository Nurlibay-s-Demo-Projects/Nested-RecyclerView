package uz.nurlibaydev.rvinnerrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.nurlibaydev.rvinnerrv.databinding.ItemChildBinding

/**
 *  Created by Nurlibay Koshkinbaev on 25/03/2023 22:59
 */

class ChildAdapter: RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    var movies = mutableListOf<Movie>()
        set(value) {
            field = value
        }

    inner class ChildViewHolder(private val binding: ItemChildBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            binding.tvParentTitle.text = movie.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(ItemChildBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_child, parent, false)))
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(movies[position])
    }
}