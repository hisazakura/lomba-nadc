package com.hisazakura.bankapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.hisazakura.bankapplication.databinding.ActivityAddEntryBinding

class AddEntry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_entry)

        val button_addEntry = findViewById<Button>(R.id.button_addEntry)

        button_addEntry.setOnClickListener{
            Toast.makeText(this,"Added Balance",Toast.LENGTH_SHORT).show()
            onBackPressed()
        }
        }
    }