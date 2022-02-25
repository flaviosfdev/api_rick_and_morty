package com.flaviosf.rickandmorty.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flaviosf.rickandmorty.data.api.ResponseApi
import com.flaviosf.rickandmorty.domain.model.character.IRickAndMortyRepository
import com.flaviosf.rickandmorty.domain.model.character.ResponseCharacters
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository : IRickAndMortyRepository
) : ViewModel() {

    // TODO: 13/01/2022 melhorar inicialização - VIEWMODEL GENÉRICA
    init {
        getCharacters()
    }

    private val _responseLiveData: MutableLiveData<ResponseCharacters> = MutableLiveData()
    val responseLiveData: LiveData<ResponseCharacters>
        get() = _responseLiveData

    private val _errorLiveData: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: LiveData<String>
        get() = _errorLiveData

    private val _prograssBar = MutableLiveData<Boolean>()
    val progressBarStatus: LiveData<Boolean>
        get() = _prograssBar

    private fun launchDataLoad(status: Boolean) {
        _prograssBar.value = status
    }

    //start da busca
    private fun getCharacters() {
        viewModelScope.launch {
            val response = repository.getCharacters()
            when (response) {
                is ResponseApi.Error -> {
                    _errorLiveData.postValue(response.message)
                    launchDataLoad(true)
                }
                is ResponseApi.Success -> {
                    _responseLiveData.postValue(response.data as ResponseCharacters)
                    launchDataLoad(false)
                }
            }
        }

    }

}