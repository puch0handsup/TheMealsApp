package com.example.themealsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.themealsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val hostFragment = supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment
        setupActionBarWithNavController(hostFragment.navController)
    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        return findNavController(R.id.frag_container).navigateUp()
//    }
}