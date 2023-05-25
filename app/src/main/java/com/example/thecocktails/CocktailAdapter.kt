package com.example.thecocktails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CocktailAdapter(private val drinks: List<Cocktail>) :

    RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.drink_item, parent, false)
        return CocktailViewHolder(view)
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        val drink = drinks[position]
        holder.bind(drink)
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    class CocktailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val drinkNameTextView: TextView = itemView.findViewById(R.id.drinkNameTextView)
        private val drinkInstructionsTextView: TextView = itemView.findViewById(R.id.drinkInstructionsTextView)

        fun bind(drink: Cocktail) {

            drinkNameTextView.text = drink.strDrink
            drinkInstructionsTextView.text = drink.strInstructions
        }
    }
}
