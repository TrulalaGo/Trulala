package gas.trulala.trulala

import android.widget.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.content.Intent
import android.view.View

public class Mulai: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
    setContentView(R.layout.mulai)
        val keluar = findViewById<Button>(R.id.keluar)
        keluar.setOnClickListener{
        startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
