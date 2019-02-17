package com.example.reflextest

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_test.*

class testActivity : AppCompatActivity() {

    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val rnd = getRandomNumber()
        testBtn.isClickable = false

        handler.postDelayed({ testBtn.setBackgroundColor(Color.rgb(76, 157, 73)) }, rnd)
        handler.postDelayed({ testBtn.isClickable = true }, rnd)
        handler.postDelayed({ redToGreen(rnd) }, rnd)

    }


    fun redToGreen(rnd: Long) {
        val start = System.currentTimeMillis()
        println(System.currentTimeMillis() - start)
        testBtn.setOnClickListener {
            println(System.currentTimeMillis() - start)
            val stop = System.currentTimeMillis() - start
            testBtn.text = """
                $stop milliseconds

                Tap to try again!
            """.trimIndent()
            println(System.currentTimeMillis() - start)
            testBtn.setOnClickListener {
                greenToRed()
            }
        }

    }

    fun greenToRed() {
        val rnd = getRandomNumber()
        testBtn.isClickable = false
        testBtn.text = ""
        testBtn.setBackgroundColor(Color.rgb(246, 2, 57))

        handler.postDelayed({ testBtn.setBackgroundColor(Color.rgb(76, 157, 73)) }, rnd)
        handler.postDelayed({ testBtn.isClickable = true }, rnd)
        handler.postDelayed({ redToGreen(rnd) }, rnd)
    }

    fun getRandomNumber(): Long {
        return (2000..6000).random().toLong()
    }

}
