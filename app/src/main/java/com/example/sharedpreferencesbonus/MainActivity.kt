package com.example.sharedpreferencesbonus

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var et1: EditText
    lateinit var et2: EditText
    lateinit var button1: Button
    lateinit var button2: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        val intent = Intent(this, MainActivity2::class.java)

        button1.setOnClickListener {
            intent.putExtra("text1", et1.text.toString())
            intent.putExtra("text2", et2.text.toString())
            startActivity(intent) }

        button2.setOnClickListener {
            sharedPreferences = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE)

            with(sharedPreferences.edit()) { putString("saved", et1.text.toString() +"\n"+ et2.text.toString())
                apply()
            }

        }

    }
}