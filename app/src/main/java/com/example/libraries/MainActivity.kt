package com.example.libraries

import android.animation.Animator
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import co.aenterhy.toggleswitch.ToggleSwitchButton
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toggle.setOnTriggerListener(object:ToggleSwitchButton.OnTriggerListener
        {
            override fun toggledUp() {
                Toast.makeText(this@MainActivity,"Camera",Toast.LENGTH_SHORT).show()
            }

            override fun toggledDown() {
                Toast.makeText(this@MainActivity,"Audio",Toast.LENGTH_SHORT).show()
            }

        })

        val mediaPlayer= MediaPlayer()
        val url="http://colorsfx.com/android/files/sample_song.mp3"
        try {

            mediaPlayer.setDataSource(url)
            mediaPlayer.prepare()
        }catch (e: Exception)
        {
            e.printStackTrace()
        }
        main_play_pause_button.setOnControlStatusChangeListener { _, state ->
            if(state)
            {
                mediaPlayer.start()
            }
            else
            {
                mediaPlayer.pause()
            }
        }

        heartBreaker.setOnClickListener {
            if(heartBreaker.isSelected)
            {
                heartBreaker.isSelected=false
                heartBreaker.likeAnimation()
            }
            else
            {
                heartBreaker.isSelected=true
                heartBreaker.likeAnimation()
            }
        }
        val list = ArrayList<String>()
        list.addAll(arrayListOf("One","two","three","four"))
        niceSpinner.attachDataSource(list)
        niceSpinner.setOnSpinnerItemSelectedListener { parent, _, position, _ ->
            val st=parent.getItemAtPosition(position).toString()
            Toast.makeText(this,st,Toast.LENGTH_SHORT).show()
        }
    }
}
