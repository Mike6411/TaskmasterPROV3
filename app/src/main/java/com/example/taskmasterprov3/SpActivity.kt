package com.example.taskmasterprov3

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)
        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this@SpActivity, MainActivity::class.java))
            finish()
        }, 3000)
    }
}