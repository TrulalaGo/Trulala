
package com.trulala.trulala

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.DocumentsContract
import androidx.documentfile.provider.DocumentFile
import android.view.LayoutInflater
import android.widget.Toast
import android.widget.ImageView
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.os.Environment
import java.io.File
import android.util.Log
import com.trulala.trulala.FileGrit

public class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val menubtn = findViewById<Button>(R.id.menubtn)
        val liner = findViewById<LinearLayout>(R.id.liner)
        val simpanbtn = findViewById<Button>(R.id.simpanbtn)
        val pengaturan = findViewById<Button>(R.id.pengaturan)
        val mulaibtn = findViewById<Button>(R.id.mulaibtn)
        val terminalbtn = findViewById<ImageView>(R.id.terminalbtn)
        val filebtn = findViewById<ImageView>(R.id.filebtn)
        val editin = findViewById<EditText>(R.id.editin)
        val grit = findViewById<GridLayout>(R.id.grit)
        menubtn.setOnClickListener{
        liner.visibility = if(liner.visibility == View.VISIBLE) View.GONE else(View.VISIBLE)}
        simpanbtn.setOnClickListener{
        Toast.makeText(this, "MENYIMPAN", Toast.LENGTH_SHORT).show()}
        pengaturan.setOnClickListener{
        val intent = Intent(this, Pengaturan::class.java)
        startActivity(intent)
        }
        mulaibtn.setOnClickListener{
        val intent = Intent(this, MulaiActivity::class.java)
        startActivity(intent)
        }
        terminalbtn.setOnClickListener{
        val intent = Intent(this, Terminal::class.java)
        startActivity(intent)
        }
        findViewById<Button>(R.id.filebtn).setOnClickListener {
    Toast.makeText(this, "FILES", Toast.LENGTH_SHORT).show()
    fileGrit.openFolder(gridLayout) // Memulai proses pemilihan folder
}

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
        val uri = data?.data
        if (uri != null) {
            // Simpan izin untuk URI yang dipilih
            contentResolver.takePersistableUriPermission(
                uri,
                Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            )

            // Panggil addFileView dengan URI
            fileGrit.addFileView(gridLayout, uri)
        } else {
            Toast.makeText(this, "Folder tidak dipilih.", Toast.LENGTH_SHORT).show()
        }
    }
}
    }
}