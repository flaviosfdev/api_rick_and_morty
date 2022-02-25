package com.flaviosf.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flaviosf.rickandmorty.databinding.ItemCharacterBinding
import com.flaviosf.rickandmorty.domain.model.character.Character
import com.flaviosf.rickandmorty.ui.util.load

class CharacterAdapter(
    private val characters: List<Character>,
    private val onClickItem: (Character) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position], onClickItem)
    }

    override fun getItemCount(): Int = characters.size

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character, onClickItem: (Character) -> Unit) {
            binding.characterName.text = character.name
            binding.characterStatus.text = character.status

            binding.characterPhoto.load(
                binding.root.context,
                character.photo.toString(),
                binding.characterPhoto
            )

            binding.root.setOnClickListener {
                onClickItem(character)
            }

        }

    }

}

