package com.example.todoapp.data

data class Note(
    val id: Int,
    val title: String,
    val desc: String?,
    val date: String,
    val saveType: String
)