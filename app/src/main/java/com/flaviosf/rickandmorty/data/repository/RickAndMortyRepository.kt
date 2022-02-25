package com.flaviosf.rickandmorty.data.repository

import android.util.Log
import com.flaviosf.rickandmorty.data.api.ResponseApi
import com.flaviosf.rickandmorty.data.api.RetrofitService
import com.flaviosf.rickandmorty.domain.model.character.IRickAndMortyRepository

//responsável pelo fornecimento dos dados - o repository é o responável pela interação da viewmodel com - AS - fontes de dados
// faz o gerenciamento de onde a aplicação vai pegar os dados
// ex: se não tiver conexão com internet, mostrar dados locais, se não, buscar da api
class RickAndMortyRepository : IRickAndMortyRepository {

    override suspend fun getCharacters(): ResponseApi {
        return try {
            val response = RetrofitService.getInstance().getAllCharacters()
            if (response.isSuccessful) ResponseApi.Success(response.body())
            else ResponseApi.Error("Personagens não  encontrados!")
        } catch (e: Exception) {
            Log.e("EXCEPTION_RETROFIT", "getCharacters: ${e.localizedMessage}")
            ResponseApi.Error("Verifique sua conexão com a internet.")
        }
    }

}