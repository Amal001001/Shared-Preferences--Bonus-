package com.example.sharedpreferencesbonus

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var tv1: TextView
    lateinit var tv2: TextView
    lateinit var button1: Button
    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tv1 = findViewById(R.id.tv1)
        tv1.text = "name: ${intent.extras?.getString("text1")!!} \nid: ${intent.extras?.getString("text2")!!}"

        tv2 = findViewById(R.id.tv2)
        button1 = findViewById(R.id.button1)
        button1.setOnClickListener {
            sharedPreferences= this.getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE)
            tv2.text= sharedPreferences.getString("saved", "").toString()
            }
    }
}