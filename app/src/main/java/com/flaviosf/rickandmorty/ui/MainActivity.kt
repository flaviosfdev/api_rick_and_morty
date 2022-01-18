package com.flaviosf.rickandmorty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.flaviosf.rickandmorty.R
import com.flaviosf.rickandmorty.databinding.ActivityMainBinding
import com.flaviosf.rickandmorty.ui.adapter.CharacterAdapter

class MainActivity : AppCompatActivity(){

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val characterAdapter: CharacterAdapter by lazy { CharacterAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerCharacters.layoutManager = LinearLayoutManager(this)
        binding.recyclerCharacters.adapter = characterAdapter

    }
}