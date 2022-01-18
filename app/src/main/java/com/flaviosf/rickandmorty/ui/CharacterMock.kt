package com.flaviosf.rickandmorty.ui

import com.flaviosf.rickandmorty.model.Character

class CharacterMock {

    companion object {
        fun getCharactersFake(): List<Character> {
            return listOf(
                Character(
                    name = "Rick Sanchez",
                    status = "Alive",
                    species = "Human",
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                ),
                Character(
                    name = "Rick Sanchez",
                    status = "Alive",
                    species = "Human",
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                ),
                Character(
                    name = "Rick Sanchez",
                    status = "Alive",
                    species = "Human",
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                ),
                Character(
                    name = "Rick Sanchez",
                    status = "Alive",
                    species = "Human",
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                ),
                Character(
                    name = "Rick Sanchez",
                    status = "Alive",
                    species = "Human",
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                ),
                Character(
                    name = "Rick Sanchez",
                    status = "Alive",
                    species = "Human",
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                )
            )
        }
    }
}