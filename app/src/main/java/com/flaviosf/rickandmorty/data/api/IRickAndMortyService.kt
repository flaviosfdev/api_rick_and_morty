package com.flaviosf.rickandmorty.data.api

import com.flaviosf.rickandmorty.domain.model.character.ResponseCharacters
import retrofit2.Response
import retrofit2.http.GET

interface IRickAndMortyService {

    @GET("character")
    suspend fun getAllCharacters(): Response<ResponseCharacters>

//    @GET("location")
//    suspend fun getAllLocations(): Response<ResponseLocation>

}