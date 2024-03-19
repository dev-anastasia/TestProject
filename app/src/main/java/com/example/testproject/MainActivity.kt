package com.example.testproject

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.ui.fragments.ListFragment
import com.example.testproject.ui.fragments.VideoFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_open_list).setOnClickListener {
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ListFragment())
                    .setReorderingAllowed(true)
                    .commit()
            }
        }

        findViewById<Button>(R.id.btn_open_video).setOnClickListener {
            if (savedInstanceState == null) {
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStack()
                }
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, VideoFragment())
                    .setReorderingAllowed(true)
                    .commit()
            }
        }
    }
}