package com.example.reflextest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportActionBar?.setIcon(R.drawable.abc_menu_hardkey_panel_mtrl_mult)
        supportActionBar?.title = "Simple Reflex Test"
        mainTextView2.text = "Click Start to begin!"
    }

    fun mainBtnClicked(view: View) {
        val startIntent = Intent(this, testActivity::class.java)
        startActivity(startIntent)
    }
}
