package io.navendra.casterkotlin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView


class CounterActivity : AppCompatActivity() {

    private val TAG = CounterActivity::class.java.name


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.counter)
        lifecycle.addObserver(LiveLogging(classInfo = ClassInfo(TAG)))

        val  counterModel  = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        counterModel.counter.observe(this, Observer {
            var textV = findViewById<TextView>(R.id.textView).apply{
                text = it.toString()
            }
        })


    }

    fun onButtonClick(v : View){

        val  counterModel  = ViewModelProviders.of(this).get(CounterViewModel::class.java)
        counterModel.increment()
        counterModel.counter.observe(this, Observer {
            var textV = findViewById<TextView>(R.id.textView).apply{
                text = it.toString()
            }
        })

    }

}