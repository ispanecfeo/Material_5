package com.example.material_3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.material_3.R
import com.example.material_3.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ViewPagerFragment.newInstance())
                .commit()
        }

        binding.bottomNav.setOnItemSelectedListener { btn ->
            when (btn.itemId) {
                R.id.action_api -> ViewPagerFragment.newInstance()
                R.id.action_wiki -> WikiFragment.newInstance()
                else -> null
            }?.also { fragment ->
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
            }
            true
        }

    }
}







