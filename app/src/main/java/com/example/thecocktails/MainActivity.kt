package com.example.thecocktails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thecocktails.CocktailApi
import com.example.thecocktails.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = binding.drinksRecyclerView

        val api = CocktailApi.service

        lifecycleScope.launch {
            val response = api.getMargarita()

            // Update the UI with the retrieved data in the main thread
            withContext(Dispatchers.Main) {
                // Access the drinks list in the response
                val drinks = response.drinks

                // Set the adapter for the RecyclerView and pass the list of drinks
                val adapter = CocktailAdapter(drinks)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = adapter
            }
        }
    }
}
