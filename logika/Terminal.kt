package com.trulala.trulala

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.*

public class Terminal: AppCompatActivity{
constructor(): super()
    override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
    setContentView(R.layout.terminal)
    val keluar =findViewById<Button>(R.id.keluar)
    keluar.setOnClickListener{
    intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
    }
    }
}
