package com.hisazakura.bankapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hisazakura.bankapplication.model.EntryData

// Kelas-kelas untuk inisialisasi RecyclerView

class EntryAdapter (private val entry: List<EntryData>): RecyclerView.Adapter<EntryHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): EntryHolder {
        return EntryHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.add_entry_layout, viewGroup, false))
    }

    override fun onBindViewHolder(holder: EntryHolder, position: Int) {
        holder.bindEntry(entry[position])
    }

    override fun getItemCount(): Int = entry.size
}

// RecyclerView menggunakan layout dari add_entry_layout.xml

class EntryHolder(view: View) : RecyclerView.ViewHolder(view){
    private val entry_text: TextView = view.findViewById(R.id.text_entry)

    fun bindEntry(entry: EntryData){
        entry_text.text = entry.name
    }
}