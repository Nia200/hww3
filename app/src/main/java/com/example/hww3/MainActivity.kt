package com.example.hww3

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate запущен!")
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        Log.d("MainActivity", "Кнопка найдена!")

        val animator = ObjectAnimator.ofFloat(button, "scaleX", 1f, 1.2f, 1f)
        animator.duration = 500
        animator.interpolator = AccelerateDecelerateInterpolator()

        button.setOnClickListener {
            Log.d("MainActivity", "Кнопка нажата!")
            animator.start()
            startActivity(Intent(this, SecondActivity::class.java))
            overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left)
        }
    }
}
