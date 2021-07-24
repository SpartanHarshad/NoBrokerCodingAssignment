package com.example.searchitemsapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.searchitemsapp.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        showSplashScreen()
    }

    private fun showSplashScreen() {
        Handler().postDelayed({
            val searchScreen = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(searchScreen)
            finish()
        }, 3000)
    }
}