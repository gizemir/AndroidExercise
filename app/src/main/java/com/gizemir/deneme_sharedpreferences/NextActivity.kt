package com.gizemir.deneme_sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gizemir.deneme_sharedpreferences.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = this.getSharedPreferences("com.gizemir.deneme_sharedpreferences", MODE_PRIVATE)
        val gelenName = sharedPreferences.getString("data", "")
        binding.textViewName.text = "Saved name: ${gelenName}"



    }
}