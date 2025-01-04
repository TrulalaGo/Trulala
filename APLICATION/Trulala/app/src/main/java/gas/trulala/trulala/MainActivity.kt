
package gas.trulala.trulala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.File
import android.view.View
import android.net.Uri
import android.content.Intent
import android.provider.DocumentsContract
import android.content.ContentResolver
import android.widget.Toast

 class MainActivity : AppCompatActivity() {
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

        setupButton(findViewById(R.id.gradle))
        setupButton(findViewById(R.id.buildozer))
        setupButton(findViewById(R.id.python))
        setupButton(findViewById(R.id.kotlin))
        setupButton(findViewById(R.id.java))
        setupButton(findViewById(R.id.javascript))
        setupButton(findViewById(R.id.html))
        setupButton(findViewById(R.id.cc))
    }

    private fun setupButton(button: Button) {
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            startActivityForResult(intent, REQUEST_CODE_PICK_FOLDER)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICK_FOLDER && resultCode == RESULT_OK) {
            val folderUri: Uri? = data?.data
            folderUri?.let { uri ->
            contentResolver.takePersistableUriPermission(
            uri,
            Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            )
            }
        }
    }

    private fun saveFileToFolder(folderUri: Uri, fileName: String, fileData: ByteArray) {
        try {
            val docUri = DocumentsContract.createDocument(
                contentResolver,
                folderUri,
                "application/octet-stream",
                fileName
            )

            docUri?.let {
                contentResolver.openOutputStream(it)?.use { outputStream ->
                    outputStream.write(fileData)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val REQUEST_CODE_PICK_FOLDER = 1
    }
 }
