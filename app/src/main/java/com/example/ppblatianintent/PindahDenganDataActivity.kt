package com.example.ppblatianintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
const val DATA_UMUR = "data_umur"
const val DATA_NAMA = "data_nama"
class PindahDenganDataActivity : AppCompatActivity() {
    private lateinit var tvTerimaData :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dengan_data)
        tvTerimaData = findViewById(R.id.tv_terima_data)
        val nama = intent.getStringExtra(DATA_NAMA)
        val umur = intent.getIntExtra(DATA_UMUR, 0)
        tvTerimaData.text = "Nama : ${nama}Umur : $umur"
    }
}