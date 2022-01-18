package com.flaviosf.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flaviosf.rickandmorty.databinding.ItemCharacterBinding
import com.flaviosf.rickandmorty.model.Character
import com.flaviosf.rickandmorty.ui.CharacterMock
import com.flaviosf.rickandmorty.ui.util.load

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characterList = CharacterMock.getCharactersFake()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int = characterList.size

    class CharacterViewHolder(private val binding: ItemCharacterBinding)
        : RecyclerView.ViewHolder(binding.root) {

            fun bind(character: Character) {
                binding.run {
                    itemCharacterName.text = character.name
                    itemCharacterStatus.text = character.status
                    itemCharacterSpecies.text = character.species
                    itemCharacterImage.load(
                        binding.root.context,
                        character.image,
                        this.itemCharacterImage
                    )
                }
            }

    }
}