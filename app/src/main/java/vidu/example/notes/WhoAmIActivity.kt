package vidu.example.notes

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WhoAmIActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.whoami)

            findViewById<Button>(R.id.btnGoBack).setOnClickListener {
                finish() // Go back to previous activity
            }
        }
    }


