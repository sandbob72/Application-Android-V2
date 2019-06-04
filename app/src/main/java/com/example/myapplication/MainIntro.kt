package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView

class MainIntro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        Handler().postDelayed({
            val intent = Intent(this@MainIntro,  MainActivity :: class.java)
            startActivity(intent)
        },3000)

        val btnOpenHome = findViewById(R.id.home) as ImageView
        btnOpenHome.setOnClickListener(){
            val intent = Intent(this@MainIntro,  MainActivity :: class.java)
            startActivity(intent)
        }
    }
}
