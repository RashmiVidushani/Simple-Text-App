import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vidu.example.notes.Note
import vidu.example.notes.R

class NoteAdapter(private val notes: List<Note>, private val onItemClick: (Note) -> Unit) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.findViewById(R.id.noteTitle)

        fun bind(note: Note) {
            noteTitle.text = note.title
            itemView.setBackgroundColor(
                if (note.priority.equals("High", ignoreCase = true))
                    Color.parseColor("#eb9f88")
                else
                    Color.parseColor("#FFFFFF")
            )
            itemView.setOnClickListener {
                onItemClick(note)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount() = notes.size
}


