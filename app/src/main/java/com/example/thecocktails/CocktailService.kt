package com.example.thecocktails

import retrofit2.http.GET

interface CocktailService {

    @GET("search.php?s=margarita")
    suspend fun getMargarita(): CocktailResponse
}

data class CocktailResponse(val drinks: List<Cocktail>)
data class Cocktail(val idDrink: String,
                    val strDrink: String,
                    val strAlcoholic: String?,
                    val strInstructions: String)
