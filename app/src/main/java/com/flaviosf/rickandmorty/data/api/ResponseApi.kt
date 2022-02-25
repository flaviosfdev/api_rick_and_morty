package com.flaviosf.rickandmorty.data.api

//essa classe gerencia o estado da aplicação
sealed class ResponseApi {

    class Success(val data: Any?) : ResponseApi()
    class Error(val message: String) : ResponseApi()

}
