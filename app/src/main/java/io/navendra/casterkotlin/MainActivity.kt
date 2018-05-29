package io.navendra.casterkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(LiveLogging(classInfo = ClassInfo(TAG)))
    }

    fun openCounterActivity(v: View){
        var i = Intent(this,CounterActivity::class.java)
        startActivity(i)
    }
}
