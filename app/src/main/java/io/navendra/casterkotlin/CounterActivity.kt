package io.navendra.casterkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class CounterActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.name

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.counter)
        lifecycle.addObserver(LiveLogging(classInfo = ClassInfo(TAG)))
    }

    fun onButtonClick(v : View){
        counter++
        var textV = findViewById<TextView>(R.id.textView).apply{
            text = counter.toString()
        }

    }

}