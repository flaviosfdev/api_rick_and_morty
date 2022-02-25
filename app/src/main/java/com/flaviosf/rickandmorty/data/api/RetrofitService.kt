package com.flaviosf.rickandmorty.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// centraliza de onde vem o serviço (configuração)
interface RetrofitService {

    // TODO: 13/01/2022 SEPARAR REQUISIÇÕES EM SERVIÇOS ESPECÍFICOS (ex: CharacterService)
    // TODO: 13/01/2022 LER SOBRE KODEIN - FERRAMENTA PARA INJEÇÃO DE DEPENDÊNCIA

    companion object {
        private val rickAndMortyService: IRickAndMortyService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(IRickAndMortyService::class.java)
        }

        fun getInstance(): IRickAndMortyService {
            return rickAndMortyService
        }
    }


}