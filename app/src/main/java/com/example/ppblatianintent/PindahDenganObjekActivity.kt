package com.example.ppblatianintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

const val DATA_MAHASISWA = "data_mahasiswa"
class PindahDenganObjekActivity : AppCompatActivity() {
    private lateinit var tvDataObject : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dengan_objek)
        tvDataObject = findViewById(R.id.tv_terima_object)
        val mahasiswa = intent.getParcelableExtra<Mahasiswa>(DATA_MAHASISWA) as Mahasiswa
        tvDataObject.text = "Nim : ${mahasiswa.nim.toString()},"+
                " \nNama : ${mahasiswa.nama.toString()}"+
                " \nEmail : ${mahasiswa.email.toString()}"+
                " \nUmur : ${mahasiswa.umur.toString()}"
    }
}