package io.navendra.casterkotlin.pokemon

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.navendra.casterkotlin.R

class PokemonDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        val id = intent.getIntExtra("id", 0)

        val pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)

        pokemonViewModel.setPokemon(id)

        val pokemon = pokemonViewModel.getPokemon()

        pokemon.observe(this, Observer {
            findViewById<TextView>(R.id.detailText).apply {
                text = it.toString()
            }
        })
    }
}
