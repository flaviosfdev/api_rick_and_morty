package com.flaviosf.rickandmorty.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.flaviosf.rickandmorty.data.repository.RickAndMortyRepository
import com.flaviosf.rickandmorty.databinding.ActivityMainBinding
import com.flaviosf.rickandmorty.domain.model.character.Character
import com.flaviosf.rickandmorty.ui.adapter.CharacterAdapter
import com.flaviosf.rickandmorty.ui.util.Constants.CHARACTER
import com.flaviosf.rickandmorty.ui.view_model.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: 13/01/2022 INSTANCIAR VIEWMODEL DE UMA MANEIRA QUE NÃO CRIE VÁRIAS INSTANCIAS
        viewModel = MainViewModel(RickAndMortyRepository())

        viewModel.progressBarStatus.observe(this) { progressBarStatus ->
            if (progressBarStatus) binding.progressBar.visibility = View.VISIBLE
            else binding.progressBar.visibility = View.GONE
        }

        viewModel.responseLiveData.observe(this) {
            configureList(it.characters)
        }

        viewModel.errorLiveData.observe(this) { errorMessage ->
            errorMessage?.let {
                Snackbar.make(
                    binding.root,
                    errorMessage,
                    Snackbar.LENGTH_INDEFINITE
                ).show()
            }
        }

    }

    private fun configureList(characters: List<Character>) {
        val recyclerCharacter = binding.recyclerCharacter
        recyclerCharacter.run {
            adapter = CharacterAdapter(characters) {character -> goToCharacterDetail(character) }
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun goToCharacterDetail(character: Character) {
        val intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra(CHARACTER, character)
        startActivity(intent)
    }
}