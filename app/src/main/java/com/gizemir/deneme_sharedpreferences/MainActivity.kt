package com.gizemir.deneme_sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gizemir.deneme_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        sharedPreferences =this.getSharedPreferences("com.gizemir.deneme_sharedpreferences", MODE_PRIVATE)
        binding.textViewSavedName.text = sharedPreferences.getString("data", "")
    }
    fun save(view: View){

        val name = binding.editTextName.text.toString()

        if(name == ""){
            Toast.makeText(this@MainActivity, "Please enter name!", Toast.LENGTH_LONG).show()
        }else{
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Save")
            alert.setMessage("Do you want to save this name?")
            alert.setPositiveButton("Yes"){diaglog, which ->
                Toast.makeText(this@MainActivity, "Name is saved", Toast.LENGTH_SHORT).show()
            }
            alert.setNegativeButton("No"){dialog, which ->
                Toast.makeText(this@MainActivity, "Name is not saved", Toast.LENGTH_SHORT).show()
            }
            alert.show()
            sharedPreferences.edit().putString("data", name).apply()
            binding.textViewSavedName.text = "Saved name: ${name}"

        }

    }
    fun delete(view: View){
        val SavedName = sharedPreferences.getString("data", "")
        if(SavedName != ""){
            sharedPreferences.edit().remove("data").apply()
            binding.textViewSavedName.text = "Saved name: "
        }
    }

    fun next(view: View){
        val intent = Intent(this@MainActivity, NextActivity::class.java)
        startActivity(intent)

    }
}