package com.example.ujiantengahsemester_22041039

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tugas_4 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tugas4)
        //Deklarasi variabel tombol
        val lpizza: ImageButton = findViewById(R.id.ib_pizza)
        val lburger: ImageButton = findViewById(R.id.ib_burger)
        val lkentang: ImageButton = findViewById(R.id.ib_kentang)
        val lhotdog: ImageButton = findViewById(R.id.ib_hotdog)

        lpizza.setOnClickListener(this)
        lburger.setOnClickListener(this)
        lkentang.setOnClickListener(this)
        lhotdog.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.ib_pizza -> {
                val intent = Intent(this@Tugas_4, Tugas_4_Pizza::class.java)
                startActivity(intent)
            }

            R.id.ib_burger -> {
                val intent = Intent(this@Tugas_4, Tugas_4_Burger::class.java)
                startActivity(intent)
            }

            R.id.ib_kentang -> {
                val intent = Intent(this@Tugas_4, Tugas_4_Kentang::class.java)
                startActivity(intent)
            }

            R.id.ib_hotdog -> {
                val intent = Intent(this@Tugas_4, Tugas_4_Hotdog::class.java)
                startActivity(intent)
            }
        }
    }
}