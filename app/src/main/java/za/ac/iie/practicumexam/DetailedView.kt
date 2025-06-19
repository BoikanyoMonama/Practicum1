package za.ac.iie.practicumexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Screen2 : AppCompatActivity() {
    // Data class to hold song review information
    data class SongReview(
        val songName: String,
        val rating: Int,
        val comment: String
    )

    private val songReviews = mutableListOf<SongReview>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen3) // Make sure you have this layout file

        // Get data passed from main screen
        val comment = intent.getStringExtra("comment")
        val rating = intent.getStringExtra("rating")
        val songName = intent.getStringExtra("songName")


        val btnShowSongs = findViewById<Button>(R.id.btnShowSongs)
        val btnCalculateAvg = findViewById<Button>(R.id.btnCalculate)
        val btnReturn = findViewById<Button>(R.id.btnReturn)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        // Button to show all songs and their details
        btnShowSongs.setOnClickListener {
            txtResult.text = " $songName " +
                               "$rating" +
                               "$comment"
            }

            // Button to calculate average rating
            btnCalculateAvg.setOnClickListener {
                if (songReviews.isEmpty()) {
                    txtResult.text = "No ratings available to calculate average."
                }

                var total = 0
                for (review in songReviews) {
                    total += review.rating
                }
                val average = total.toDouble() / songReviews.size
                txtResult.text = String.format("Average Rating: $rating", average)
            }

            // Button to return to main screen
            btnReturn.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Optional: closes this activity
            }
        }
    }


