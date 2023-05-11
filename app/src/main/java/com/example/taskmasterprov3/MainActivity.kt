package com.example.taskmasterprov3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.LinearLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.taskmasterprov3.Adapter.NotesAdapter
import com.example.taskmasterprov3.Database.NoteDatabase
import com.example.taskmasterprov3.Models.Note
import com.example.taskmasterprov3.Models.NoteViewModel
import com.example.taskmasterprov3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: NoteDatabase
    lateinit var viewModel: ViewModel
    lateinit var adapter: NotesAdapter
    lateinit var selectedNote : Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Inicialitzar la UI
        initUI()

        viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

        (viewModel as NoteViewModel).allnotes.observe(this) { list ->

            list?.let {

                adapter.updateList(list)

            }

        }

        database = NoteDatabase.getDatabase(this)

    }

    private fun initUI() {

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)

    }
}