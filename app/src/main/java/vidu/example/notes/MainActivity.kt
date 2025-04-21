package vidu.example.notes

import NoteAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    var notes = mutableListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val noteTitle = findViewById<EditText>(R.id.noteTitle)
        val noteDescription = findViewById<EditText>(R.id.noteDescription)
        val priority = findViewById<EditText>(R.id.highLow)
        val btnAddNote = findViewById<Button>(R.id.btnAddNote)
        val btnWhoAmI = findViewById<Button>(R.id.btnWhoAmI)
        recyclerView = findViewById(R.id.recyclerView)

        // Set RecyclerView adapter
        noteAdapter = NoteAdapter(notes) { note ->
            val intent = Intent(this, NoteDetailactivty::class.java).apply {
                putExtra("title", note.title)
                putExtra("description", note.description)
                putExtra("priority", note.priority)
            }
            startActivity(intent)
        }

        recyclerView.adapter = noteAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        // Add note
        btnAddNote.setOnClickListener {
            val title: String = noteTitle.text.toString()
            val description: String = noteDescription.text.toString()
            val prioritylevel: String = priority.text.toString()

            if (title.isNotEmpty() && description.isNotEmpty() && prioritylevel.isNotEmpty()) {
                val note = Note(title, description, prioritylevel)
                notes.add(note)
                noteAdapter.notifyDataSetChanged()

                noteTitle.text.clear()
                noteDescription.text.clear()
                priority.text.clear()
            }
        }

        // Who Am I button
        btnWhoAmI.setOnClickListener {
            val intent = Intent(this, WhoAmIActivity::class.java)
            startActivity(intent)
        }

    }
}

data class Note(
    val title: String,
    val description: String,
    val priority: String
)
