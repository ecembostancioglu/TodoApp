package com.example.todoapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.data.model.Note
import com.example.todoapp.databinding.ItemHomeBinding

class HomeAdapter(
    private val onNoteClick: (String) -> Unit
): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>()  {

    private val noteList = mutableListOf<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(
            ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) =
        holder.bind(noteList[position])

    inner class HomeViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            with(binding) {
                tvTitle.text = note.title
                tvDate.text = note.date

                root.setOnClickListener {
                    note.desc?.let(onNoteClick)
                }
            }
        }
    }

    fun updateList(list: List<Note>) {
        noteList.clear()
        noteList.addAll(list)
        notifyItemRangeChanged(0, list.size)
    }

    override fun getItemCount() = noteList.size

}

//39.45