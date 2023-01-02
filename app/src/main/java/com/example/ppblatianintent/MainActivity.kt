package com.example.ppblatianintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var btnMoveActivity : Button
    private lateinit var btnMoveActivityWithData : Button
    private lateinit var btnMoveActivityWithObject : Button
    private lateinit var btnImplicit : Button
    private lateinit var btnPindahDapatHasil : Button
    private lateinit var tvHasilActivity : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivityWithData = findViewById(R.id.btn_move_activity_with_data)
        btnMoveActivityWithObject = findViewById(R.id.btn_move_activity_with_object)
        btnImplicit = findViewById(R.id.btn_implicit)
        btnPindahDapatHasil = findViewById(R.id.btn_pindah_dapat_hasil)
        tvHasilActivity = findViewById(R.id.tv_hasil_activity)

        btnMoveActivity.setOnClickListener {
            btnMoveActivityAction()
        }
        btnMoveActivityWithData.setOnClickListener {
            btnMoveActivityWithDataAction()
        }
        btnMoveActivityWithObject.setOnClickListener {
            btnMoveActivityWithObjectAction()
        }
        btnImplicit.setOnClickListener {
            btnImplicitAction()
        }
        btnPindahDapatHasil.setOnClickListener {
            btnPindahDenganHasilAction()
        }
    }

    private fun btnMoveActivityAction(){
        val intent = Intent(this,PindahActivity::class.java)
        startActivity(intent)
    }

    private fun btnMoveActivityWithDataAction(){
        val intent = Intent(this, PindahDenganDataActivity::class.java)
        intent.putExtra(DATA_NAMA,"Cahyo, ")
        intent.putExtra(DATA_UMUR,19)
        startActivity(intent)

    }
    private fun btnMoveActivityWithObjectAction(){
        val mahasiswa = Mahasiswa(
            "2042101827",
            "Cahyo",
            19,
            "widhiantoc@gmail.com"
        )
        val intent = Intent(this, PindahDenganObjekActivity::class.java)
        intent.putExtra(DATA_MAHASISWA, mahasiswa)
        startActivity(intent)
    }

    private fun btnImplicitAction(){
        val noHp = "+62982178225378"
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$noHp"))
        startActivity(intent)
    }

    private fun btnPindahDenganHasilAction(){
        val intent = Intent(this,PindahDenganResultActivity::class.java)
        resultLauncher.launch(intent)
    }


    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result ->
        if (result.resultCode == KODE_HASIL && result.data !=null){
            val makananPilihan = result.data?.getStringExtra(MAKANAN_PILIHAN)
            tvHasilActivity.text = makananPilihan
        }
    }
}