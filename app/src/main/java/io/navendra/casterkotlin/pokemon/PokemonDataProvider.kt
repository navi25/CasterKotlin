package io.navendra.casterkotlin.pokemon

import android.arch.lifecycle.MutableLiveData

data class PokemonModel(
        var id:Int,
        var name:String,
        var type:String
)

object PokemonDataProvider{

    private val pokemons = listOf(
            PokemonModel(0, "Pokemon Zero - Bulbasur","water"),
            PokemonModel(1, "Pokemon One - Bulbasur","water"),
            PokemonModel(2, "Pokemon Two - Bulbasur","water"),
            PokemonModel(3, "Pokemon Three - Bulbasur","water"),
            PokemonModel(4, "Pokemon Four - Bulbasur","water"),
            PokemonModel(5, "Pokemon Five - Bulbasur","water")
    )

    fun getPokemons() = pokemons

    fun getPokemonsLive() = MutableLiveData<List<PokemonModel>>().apply {
        value = pokemons
    }

    fun getPokemons(id:Int) = pokemons.first{it.id == id}

    fun getPokemonsLive(id:Int) = MutableLiveData<PokemonModel>().apply {
        value = pokemons.first{ it.id == id}
    }
}