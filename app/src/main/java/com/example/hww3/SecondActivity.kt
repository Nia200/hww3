package com.example.hww3

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.animations.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // View Animation (Bounce)
        val bounceAnim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        binding.imageView2.startAnimation(bounceAnim)
    }
}
