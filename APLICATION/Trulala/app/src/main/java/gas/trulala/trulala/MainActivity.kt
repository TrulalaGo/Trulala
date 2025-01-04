
package gas.trulala.trulala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.File
import android.view.View

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
   }
}
