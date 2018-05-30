package io.navendra.casterkotlin.pokemon

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel



class PokemonViewModel : ViewModel(){
    private var pokemons: MutableLiveData<List<PokemonModel>> = MutableLiveData()

    private var pokemon: LiveData<PokemonModel>
    private var pokemonId: MutableLiveData<Int> = MutableLiveData()

    init {
        pokemons.value = PokemonDataProvider.getPokemons()
        pokemon = Transformations.map(pokemonId){
            PokemonDataProvider.getPokemons(it)
        }
    }

    fun setPokemon(id:Int){
        pokemonId.value = id
    }

    fun getPokemon() = pokemon
}