package uz.nurlibaydev.rvinnerrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.nurlibaydev.rvinnerrv.databinding.ChildItemBinding

/**
 *  Created by Nurlibay Koshkinbaev on 25/03/2023 21:19
 */

class ChildAdapter : RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    var movies = mutableListOf<Movie>()
        set(value) {
            field = value
        }

    inner class ChildViewHolder(private val binding: ChildItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.apply {
                childTitle.text = movie.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(ChildItemBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.child_item, parent, false)))
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(movies[position])
    }
}