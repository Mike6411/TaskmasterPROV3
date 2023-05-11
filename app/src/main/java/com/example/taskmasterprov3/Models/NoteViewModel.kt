package com.example.taskmasterprov3.Models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.taskmasterprov3.Database.NoteDatabase
import com.example.taskmasterprov3.Database.NotesRepository

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : NotesRepository

    val allnotes : LiveData<List<Note>>

    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repository = NotesRepository(dao)
        allnotes = repository.allNotes
    }


}