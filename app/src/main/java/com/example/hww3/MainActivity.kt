package com.example.hww3

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.animations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Анимация логотипа при старте
        animateAppIcon()

        // Lottie-анимация
        val lottieAnimation = findViewById<LottieAnimationView>(R.id.lottie_animation)
        lottieAnimation.setAnimation("loading.json")
        lottieAnimation.playAnimation()

        // View Animation (Scale, Alpha)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.textView.startAnimation(fadeIn)

        // Property Animation (Rotation)
        val rotateAnim = ObjectAnimator.ofFloat(binding.imageView, "rotation", 0f, 360f)
        rotateAnim.duration = 2000
        rotateAnim.repeatCount = ValueAnimator.INFINITE
        rotateAnim.start()

        // Кнопка для перехода на второй экран
        binding.buttonNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }

    private fun animateAppIcon() {
        val iconAnimator = ObjectAnimator.ofFloat(binding.appIcon, "scaleX", 0.5f, 1.5f)
        iconAnimator.duration = 1500
        iconAnimator.interpolator = AccelerateDecelerateInterpolator()
        iconAnimator.repeatCount = ValueAnimator.INFINITE
        iconAnimator.repeatMode = ValueAnimator.REVERSE
        iconAnimator.start()
    }
}
