package com.example.testproject

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.application.component
import com.example.testproject.ui.UsersViewModel
import com.example.testproject.ui.UsersViewModelFactory
import com.example.testproject.ui.fragments.ListFragment
import com.example.testproject.ui.fragments.VideoFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vmFactory: UsersViewModelFactory
    private lateinit var vm: UsersViewModel

    private var isListBtnEnabled = true
    private var isVideoBtnEnabled = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            isListBtnEnabled = savedInstanceState.getBoolean(LIST_BTN_KEY)
            isVideoBtnEnabled = savedInstanceState.getBoolean(VIDEO_BTN_KEY)
        }

        component.inject(this)
        vm = ViewModelProvider(this, vmFactory)[UsersViewModel::class.java]

        val btnList: Button = findViewById(R.id.btn_open_list)
        btnList.isEnabled = isListBtnEnabled
        val btnVideo: Button = findViewById(R.id.btn_open_video)
        btnVideo.isEnabled = isVideoBtnEnabled

        btnList.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListFragment(), LIST_FR_TAG)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
        }

        btnVideo.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, VideoFragment(), VIDEO_FR_TAG)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
        }

        supportFragmentManager.addOnBackStackChangedListener {

            if (supportFragmentManager.fragments.isEmpty()) {
                enableListBtn(btnList)
                enableVideoBtn(btnVideo)
            } else {
                if (supportFragmentManager.fragments.last() ==
                    supportFragmentManager.findFragmentByTag(LIST_FR_TAG) ||
                    supportFragmentManager.fragments.last() ==
                    supportFragmentManager.findFragmentByTag(INFO_FR_TAG)
                ) {
                    disableListBtn(btnList)
                    enableVideoBtn(btnVideo)
                    return@addOnBackStackChangedListener
                }
                if (supportFragmentManager.fragments.last() ==
                    supportFragmentManager.findFragmentByTag(VIDEO_FR_TAG)
                ) {
                    disableVideoBtn(btnVideo)
                    enableListBtn(btnList)
                    return@addOnBackStackChangedListener
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBoolean(LIST_BTN_KEY, isListBtnEnabled)
        outState.putBoolean(VIDEO_BTN_KEY, isVideoBtnEnabled)
    }

    private fun enableListBtn(listBtn: Button) {
        listBtn.apply {
            isEnabled = true
            isListBtnEnabled = true
            setBackgroundColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    R.color.blueish
                )
            )
        }
    }

    private fun enableVideoBtn(videoBtn: Button) {
        videoBtn.apply {
            isEnabled = true
            isVideoBtnEnabled = true
            setBackgroundColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    R.color.blueish
                )
            )
        }
    }

    private fun disableListBtn(listBtn: Button) {
        listBtn.apply {
            isEnabled = false
            isListBtnEnabled = false
            setBackgroundColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    R.color.light_grey
                )
            )
        }
    }

    private fun disableVideoBtn(videoBtn: Button) {
        videoBtn.apply {
            isEnabled = false
            isVideoBtnEnabled = false
            setBackgroundColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    R.color.light_grey
                )
            )
        }
    }

    companion object {
        private const val LIST_BTN_KEY = "LIST_BTN"
        private const val VIDEO_BTN_KEY = "VIDEO_BTN"
        private const val LIST_FR_TAG = "LIST_TAG"
        private const val VIDEO_FR_TAG = "VIDEO_TAG"
        const val INFO_FR_TAG = "INFO_TAG"
    }
}