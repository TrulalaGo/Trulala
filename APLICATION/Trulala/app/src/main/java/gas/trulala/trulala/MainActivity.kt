
package gas.trulala.trulala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.File
import android.view.View
import android.content.Intent
import android.widget.Toast

public class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val menubtn = findViewById<Button>(R.id.menubtn)
        val liner = findViewById<LinearLayout>(R.id.liner)
        menubtn.setOnClickListener{
        liner.visibility = if(liner.visibility == View.GONE){View.VISIBLE}
        else{View.GONE}
        }
        val simpan = findViewById<Button>(R.id.simpan)
        val mulai = findViewById<Button>(R.id.mulai)
        mulai.setOnClickListener{
        val intent = Intent(this, Mulai::class.java)
        startActivity(intent)
        }
        simpan.setOnClickListener{
        Toast.makeText(this, "Menyimpan", Toast.LENGTH_SHORT).show()
        }
        val editin = findViewById<EditText>(R.id.editin)
        val koreksi = findViewById<TextView>(R.id.koreksi)
        val gd = findViewById<Button>(R.id.gradle)
        val bo = findViewById<Button>(R.id.buildozer)
        val py = findViewById<Button>(R.id.python)
        val kt = findViewById<Button>(R.id.kotlin)
        val kodej = findViewById<Button>(R.id.java)
        val js = findViewById<Button>(R.id.javascript)
        val html = findViewById<Button>(R.id.html)
        val cc = findViewById<Button>(R.id.cc)
        gd.setOnClickListener{}
        bo.setOnClickListener{}
        py.setOnClickListener{}
        kt.setOnClickListener{}
        kodej.setOnClickListener{}
        js.setOnClickListener{}
        html.setOnClickListener{}
        cc.setOnClickListener{}
   }
}
