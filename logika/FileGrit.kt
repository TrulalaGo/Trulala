package com.trulala.trulala

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.documentfile.provider.DocumentFile
import android.view.LayoutInflater
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView

class FileGrit(private val context: Context, private val activity: Activity) {
fun addFileView(grit: GridLayout, uri: Uri) {
    val documentTree = DocumentFile.fromTreeUri(context, uri)
    grit.removeAllViews()

    documentTree?.listFiles()?.forEach { file: DocumentFile ->
        val itemView = LayoutInflater.from(context).inflate(R.layout.file_item, grit, false)
        val imageView = itemView.findViewById<ImageView>(R.id.file_ikon)
        val textView = itemView.findViewById<TextView>(R.id.file_text)

        if (file.isDirectory) {
            imageView.setImageResource(R.drawable.folder)
        } else if (file.name?.endsWith(".jpg", true) == true || file.name?.endsWith(".png", true) == true) {
            imageView.setImageResource(R.drawable.foto)
        } else {
            imageView.setImageResource(R.drawable.file)
        }

        textView.text = file.name
        grit.addView(itemView)
    }
}
}