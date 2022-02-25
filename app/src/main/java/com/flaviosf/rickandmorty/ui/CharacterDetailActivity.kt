package com.flaviosf.rickandmorty.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flaviosf.rickandmorty.databinding.ActivityCharacterDetailBinding
import com.flaviosf.rickandmorty.domain.model.character.Character
import com.flaviosf.rickandmorty.ui.util.Constants
import com.flaviosf.rickandmorty.ui.util.load

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailBinding
    private var character: Character? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        character = intent.getParcelableExtra(Constants.CHARACTER)

        setupUi(character = character)
    }

    private fun setupUi(character: Character?) {
        binding.characterDetailName.text = character?.name
        binding.characterDetailStatus.text = character?.status
        binding.characterDetailGender.text = character?.gender

        binding.characterDetailPhoto.load(
            context = this,
            url = character?.photo.toString(),
            view = binding.characterDetailPhoto
        )
    }
}