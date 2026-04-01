package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextTimeOfDay: EditText
    private lateinit var buttonGetSuggestion: Button
    private lateinit var textViewSuggestion: TextView
    private lateinit var buttonReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        editTextTimeOfDay = findViewById(R.id.editTextTimeOfDay)
        buttonGetSuggestion = findViewById(R.id.buttonSuggestion)
        textViewSuggestion = findViewById(R.id.textViewSuggestion)
        buttonReset = findViewById(R.id.buttonReset)

        // Get Suggestion button
        buttonGetSuggestion.setOnClickListener {

            val timeOfDay = editTextTimeOfDay.text.toString().trim().lowercase()

            val suggestion = getSocialSparkSuggestion(timeOfDay)

            if (suggestion.isNotEmpty()) {
                textViewSuggestion.text = suggestion
            } else {
                Toast.makeText(
                    this,
                    "Please enter a valid time of day (Morning, Afternoon, etc.)",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Reset button
        buttonReset.setOnClickListener {
            editTextTimeOfDay.text.clear()
            textViewSuggestion.text = "Suggestion will appear here"
        }
    }

    // Function to provide suggestion
    private fun getSocialSparkSuggestion(timeOfDay: String): String {
        return when (timeOfDay) {
            "morning" -> "Send a 'Good morning' text to a family member."
            "mid-morning" -> "Reach out to a colleague with a quick 'Thank you.'"
            "afternoon" -> "Share a funny meme or interesting link with a friend."
            "afternoon snack time" -> "Send a quick 'thinking of you' message."
            "dinner" -> "Call a friend or relative for a 5-minute catch-up."
            "after dinner", "night" -> "Leave a thoughtful comment on a friend's post."
            else -> ""
        }
    }
}
