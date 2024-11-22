package com.example.tugas2_emptyviewactivity

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter
    private lateinit var emptyView: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi view
        emptyView = findViewById(R.id.empty_view)
        recyclerView = findViewById(R.id.recycler_view)

        // Set up adapter dan layout manager untuk RecyclerView
        taskAdapter = TaskAdapter(mutableListOf())
        recyclerView.adapter = taskAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Tombol tambah tugas
        findViewById<FloatingActionButton>(R.id.fab_add_task).setOnClickListener {
            addTaskDialog()
        }

        updateEmptyView()
    }

    // Fungsi untuk menampilkan dialog tambah tugas
    private fun addTaskDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Tambah Tugas")

        // Input field untuk memasukkan tugas
        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        // Button untuk menambah tugas
        builder.setPositiveButton("Tambah") { _, _ ->
            val task = input.text.toString()
            if (task.isNotEmpty()) {
                taskAdapter.addTask(task)
                updateEmptyView()
            }
        }

        // Button untuk batal menambah tugas
        builder.setNegativeButton("Batal") { dialog, _ -> dialog.cancel() }

        builder.show()
    }

    // Fungsi untuk memperbarui empty view (tampilan kosong) jika belum ada tugas
    private fun updateEmptyView() {
        if (taskAdapter.itemCount == 0) {
            emptyView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            emptyView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }
}
