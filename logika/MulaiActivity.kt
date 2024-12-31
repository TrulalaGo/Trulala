package com.trulala.trulala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.content.Intent

class MulaiActivity: AppCompatActivity{
constructor(): super()
    override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
    setContentView(R.layout.mulai)
    val keluar = findViewById<Button>(R.id.keluar)
    keluar.setOnClickListener{
    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
    }
    }
}
