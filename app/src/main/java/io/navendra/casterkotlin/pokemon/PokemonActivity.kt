package io.navendra.casterkotlin.pokemon

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import io.navendra.casterkotlin.R


class PokemonActivity : AppCompatActivity() {

    private val TAG:String = PokemonActivity::class.java.name

    enum class POKEMON(val id:Int, val text:Int){
        ZERO(R.id.p0, R.string.p0),
        ONE(R.id.p1, R.string.p1),
        TWO(R.id.p2, R.string.p2),
        THREE(R.id.p3, R.string.p3),
        FOUR(R.id.p4, R.string.p4),
        FIVE(R.id.p5, R.string.p5),
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)
        setupClicks()
    }

    fun setupClicks(){
        val pokemons = enumValues<POKEMON>()
        for (i in 0..5) {
            val id = pokemons[i].id
            val nameId = pokemons[i].text
            val currentPokemonView = findViewById<TextView>(id)
            val textName = getString(nameId)
            currentPokemonView.setOnClickListener{
                Log.d(TAG,textName + " is clicked!!")
                OpenPokemonDetailView(i)
            }
        }
    }


    fun OpenPokemonDetailView(id:Int){
        val intent =  Intent(this, PokemonDetailActivity::class.java).apply {
            putExtra("id",id)
        }

        startActivity(intent)
    }


}
