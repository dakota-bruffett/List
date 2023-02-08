package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var addGuestButton: Button
    lateinit var newGuestEditText: EditText
    lateinit var ClearliistButton: Button
    lateinit var Guesslist:TextView
    lateinit var Latest_name:TextView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
        addGuestButton = findViewById(R.id.AddGuestButton)
        newGuestEditText = findViewById(R.id.NewGuessList)
        ClearliistButton = findViewById(R.id.ClearListButton)
        Guesslist = findViewById(R.id.Guesslist)
        Latest_name = findViewById(R.id.Latest_name)

        addGuestButton.setOnClickListener {
            addNewGuest()
        }
        ClearliistButton.setOnClickListener {
            GuesslistViewModel.clearGuesslist()
            listGuessadded.text =""
            updateGuessList()


        }
        val  savedLastguestmessage = savedInstanceState?.getString(LAST_GUESS_NAME)
        lastGuestAdded.text = savedLastguestmessage
        updateGuesslist()

    }
    private fun addNewGuest(){
        val newGuessName = newGuestEditText.text
        if (newGuessName.isBlank()) {
            GuestlistViewModel.addGuest(newGuessName)
            updateGuestList()
            newGuestEditText.text.clear()
            lastguestsAdded.text = getString(R.string.your_name_here)
        }
    }
    private fun updateGuessList(){
        val guestDisplay = guestlistViewModel.getSortedGuestnames().jointoString(separator="\n")
        guessList.text = guestDisplay
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}