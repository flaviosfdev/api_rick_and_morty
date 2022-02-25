package com.flaviosf.rickandmorty

import com.flaviosf.rickandmorty.data.api.ResponseApi
import com.flaviosf.rickandmorty.domain.model.character.Character
import com.flaviosf.rickandmorty.domain.model.character.IRickAndMortyRepository
import com.flaviosf.rickandmorty.ui.view_model.MainViewModel
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
        val mainViewModel = MainViewModel(RepositoryFake())
    }
}

class RepositoryFake : IRickAndMortyRepository {

    override suspend fun getCharacters(): ResponseApi {
        return ResponseApi.Success(listOf(
            Character(
                name = "flavio",
                status = "confuso",
                photo = "",
                gender = "male"
            )
        ))
    }

}