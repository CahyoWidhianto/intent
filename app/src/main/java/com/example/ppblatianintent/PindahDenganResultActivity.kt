package com.example.ppblatianintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup

const val MAKANAN_PILIHAN="makanan_pilihan"
const val KODE_HASIL= 110

class PindahDenganResultActivity : AppCompatActivity() {
    private lateinit var btnPilih : Button
    private lateinit var rgMakanan : RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dengan_result)
        btnPilih = findViewById(R.id.btn_pilih)
        rgMakanan = findViewById(R.id.rg_makanan)

        btnPilih.setOnClickListener {
            var makanan = ""
            when(rgMakanan.checkedRadioButtonId){
                R.id.rb_nasi_goreng ->makanan = "Nasi Goreng"
                R.id.rb_lotek ->makanan = "Lotek"
                R.id.rb_burjo ->makanan = "Burjo"
            }
            val resultIntent = Intent()
            resultIntent.putExtra(MAKANAN_PILIHAN,makanan)
            setResult(KODE_HASIL, resultIntent)
            finish()
        }
    }
}