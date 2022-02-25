package com.flaviosf.rickandmorty.domain.model.character

import com.google.gson.annotations.SerializedName

data class ResponseCharacters(
    @SerializedName("results")
    val characters: List<Character>
)