package uz.nurlibaydev.rvinnerrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.nurlibaydev.rvinnerrv.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private val adapter = ChildAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val parent = intent.getSerializableExtra("item_data") as Parent

        binding.tvTitle.text = parent.title
        binding.rvMovies.adapter = adapter
        adapter.movies = parent.movies.toMutableList()

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}