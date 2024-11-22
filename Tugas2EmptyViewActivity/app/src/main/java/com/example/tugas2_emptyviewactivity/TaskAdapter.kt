package com.example.tugas2_emptyviewactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// TaskAdapter akan menerima list of tasks
class TaskAdapter(private val tasks: MutableList<String>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    // Inner class untuk ViewHolder yang merepresentasikan setiap item di RecyclerView
    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTextView: TextView = itemView.findViewById(R.id.task_text)
    }

    // Menghubungkan layout item_task.xml dengan ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    // Menghubungkan data dengan TextView di setiap item
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.taskTextView.text = tasks[position]
    }

    // Mengembalikan jumlah item di list
    override fun getItemCount(): Int {
        return tasks.size
    }

    // Fungsi untuk menambah tugas baru
    fun addTask(task: String) {
        tasks.add(task)
        notifyItemInserted(tasks.size - 1)
    }
}

