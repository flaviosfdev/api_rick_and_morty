package com.flaviosf.rickandmorty.domain.model.character

import com.flaviosf.rickandmorty.data.api.ResponseApi

interface IRickAndMortyRepository {

    suspend fun getCharacters(): ResponseApi

}