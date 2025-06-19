package za.ac.iie.practicumexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val edtComment = findViewById<EditText>(R.id.edtComment)
        val edtRating = findViewById<EditText>(R.id.edtRating)
        val song1 = findViewById<RadioButton>(R.id.song1)
        val song2 = findViewById<RadioButton>(R.id.song2)
        val song3 = findViewById<RadioButton>(R.id.song3)
        val song4 = findViewById<RadioButton>(R.id.song4)


        // Reference to Buttons and TextView
        val add = findViewById<Button>(R.id.btnPlaylist)
        val exit = findViewById<Button>(R.id.btnExit)
        val next = findViewById<Button>(R.id.btnMove)
        val results = findViewById<TextView>(R.id.txtResults)


        add.setOnClickListener{
            results.text = "Please select song, rate it 1-5 and make a comment on it"
        }

        next.setOnClickListener {
            val comment = edtComment.text.toString().trim()
            val rating = edtRating.text.toString().trim()
            var selectedSong = ""
            if (song1.isChecked){
                selectedSong = song1.text.toString()
            }
            if (song2.isChecked){
                selectedSong = song2.text.toString()
            }
            if (song3.isChecked){
                selectedSong = song3.text.toString()
            }
            if (song4.isChecked){
                selectedSong = song4.text.toString()
            }
            val ratingInt = rating.toIntOrNull()
            if (ratingInt !in 1..5) {
                val intent = Intent(this, Screen2::class.java)
                intent.putExtra("comment", comment)
                intent.putExtra("rating", rating)
                intent.putExtra("songName", selectedSong)
                startActivity(intent)
            }

            exit.setOnClickListener {
                finish()
                finishAffinity()
            }

        }
    }

}
