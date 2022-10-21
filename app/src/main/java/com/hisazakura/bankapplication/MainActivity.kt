package com.hisazakura.bankapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hisazakura.bankapplication.databinding.ActivityMainBinding
import com.hisazakura.bankapplication.model.EntryData

// Activity untuk melihat saldo dan riwayat pemasukan/pengeluaran

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Fungsi yang dijalankan ketika tombol fab ditekan (lihat activity_main.xml)
        binding.fab.setOnClickListener {
            gotoActivity(AddEntryActivity())
        }

        // Data untuk testing
        val listentry = listOf<EntryData>(
            EntryData("Makan", 10f),
            EntryData("Minum", 2f)
        )

        // Inisialisasi RecyclerView
        val entryRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        entryRecyclerView.layoutManager = LinearLayoutManager(this)
        val entry_adapter = EntryAdapter(listentry)
        entryRecyclerView.adapter = entry_adapter
    }

    // Fungsi pindah Activity
    fun gotoActivity(activity: Activity){
        intent = Intent(this,activity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}