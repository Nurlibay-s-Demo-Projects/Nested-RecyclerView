package uz.nurlibaydev.rvinnerrv

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.nurlibaydev.rvinnerrv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val parentAdapter = ParentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvParent.adapter = parentAdapter

        val data = mutableListOf<Parent>()

        repeat(10) {
            val movies = mutableListOf<Movie>()
            repeat(10) { movie ->
                movies.add(Movie("Movie ${movie + 1}"))
            }
            data.add(Parent("Parent title ${it + 1}", movies))
        }

        parentAdapter.list.addAll(data)

        parentAdapter.setOnItemClickListener {
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra("item_data", it)
            startActivity (i)
        }
    }
}