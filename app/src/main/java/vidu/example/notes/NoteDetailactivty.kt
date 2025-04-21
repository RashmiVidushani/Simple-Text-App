package vidu.example.notes

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class NoteDetailactivty : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.note_detail_activity)

            val noteTitle = intent.getStringExtra("title")
            val noteDescription = intent.getStringExtra("description")

            findViewById<TextView>(R.id.noteDetailTitle).text = noteTitle
            findViewById<TextView>(R.id.noteDetailDescription).text = noteDescription

            findViewById<Button>(R.id.btnGoBack).setOnClickListener {
                finish()
            }
        }
    }

