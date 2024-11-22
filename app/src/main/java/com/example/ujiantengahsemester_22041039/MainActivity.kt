package com.example.ujiantengahsemester_22041039

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val tugas1: ImageButton = findViewById(R.id.ib_tugas_1)
        val tugas2: ImageButton = findViewById(R.id.ib_tugas_2)
        val tugas3: ImageButton = findViewById(R.id.ib_tugas_3)
        val tugas4: ImageButton = findViewById(R.id.ib_tugas_4)

        tugas1.setOnClickListener(this)
        tugas2.setOnClickListener(this)
        tugas3.setOnClickListener(this)
        tugas4.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.ib_tugas_1 -> {
                val intent = Intent(this@MainActivity, Tugas_1::class.java)
                startActivity(intent)
            }

            R.id.ib_tugas_2 -> {
                val intent = Intent(this@MainActivity, Tugas_2::class.java)
                startActivity(intent)
            }

            R.id.ib_tugas_3 -> {
                val intent = Intent(this@MainActivity, Tugas_3::class.java)
                startActivity(intent)
            }

            R.id.ib_tugas_4 -> {
                val intent = Intent(this@MainActivity, Tugas_4::class.java)
                startActivity(intent)
            }
        }
    }
}