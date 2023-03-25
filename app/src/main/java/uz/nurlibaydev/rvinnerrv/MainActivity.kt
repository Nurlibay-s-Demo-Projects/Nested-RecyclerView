package uz.nurlibaydev.rvinnerrv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.nurlibaydev.rvinnerrv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val parentAdapter = ParentAdapter()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.adapter = parentAdapter

        val data = mutableListOf<Parent>()
        repeat(20) {
            val movies = arrayListOf<Movie>()
            repeat(10) { movieTitle ->
                movies.add(Movie("Movie title ${movieTitle + 1}"))
            }
            data.add(Parent("Parent title ${it + 1}", movies))
        }
        parentAdapter.list = data
    }
}