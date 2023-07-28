package com.example.todoapp.data.data.source

import com.example.todoapp.data.data.model.Note

object NoteDatabase {

    private val allNotes = mutableListOf<Note>()

    fun getNotes() = allNotes

    fun addDailyNote(title: String, desc: String, date: String, saveType: String) {
        allNotes.add(
            Note(
                id = (allNotes.lastOrNull()?.id ?: 0) + 1,
                title = title,
                desc = desc,
                date = date,
                saveType = saveType
            )
        )
    }

    fun removeDailyNote(note: Note) = allNotes.remove(note)
}