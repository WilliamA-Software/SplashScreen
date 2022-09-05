package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val rotateOpen: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim)}
    private val rotateClose: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim)}
    private val fromBottom: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim)}
    private val toBottom: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim)}

    private lateinit var fabSettings : FloatingActionButton
    private lateinit var fabTv: FloatingActionButton
    private lateinit var fabVideoCam: FloatingActionButton

    private var clickedFabSettings: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabSettings = findViewById(R.id.fab_settings)
        fabTv = findViewById(R.id.fab_tv)
        fabVideoCam = findViewById(R.id.fab_video)

        fabSettings.setOnClickListener {
            onAddButtonClicked()
        }

        fabTv.setOnClickListener {
            Toast.makeText(this, getString(R.string.clicked_fab_tv),Toast.LENGTH_SHORT).show()
        }

        fabVideoCam.setOnClickListener {
            Toast.makeText(this, getString(R.string.clicked_fab_video),Toast.LENGTH_SHORT).show()
        }


    }

    private fun onAddButtonClicked(){
        setVisibility(clickedFabSettings)
        setAnimation(clickedFabSettings)
        setClickable(clickedFabSettings)
        clickedFabSettings = !clickedFabSettings
    }

    private fun setVisibility(clicked: Boolean) {
        if(!clicked){
            fabTv.visibility = View.VISIBLE
            fabVideoCam.visibility = View.VISIBLE
        }else{
            fabTv.visibility = View.INVISIBLE
            fabVideoCam.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if(!clicked){
            fabTv.startAnimation(fromBottom)
            fabVideoCam.startAnimation(fromBottom)
            fabSettings.startAnimation(rotateOpen)
        }else{
            fabTv.startAnimation(toBottom)
            fabVideoCam.startAnimation(toBottom)
            fabSettings.startAnimation(rotateClose)
        }
    }

    private fun setClickable(clicked: Boolean){
        if(!clicked){
            fabTv.isClickable = true
            fabVideoCam.isClickable = true
        }else{
            fabTv.isClickable = false
            fabVideoCam.isClickable = false
        }
    }

}