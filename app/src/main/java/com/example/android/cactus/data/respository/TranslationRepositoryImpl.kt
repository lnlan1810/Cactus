package com.example.android.cactus.data.respository

import com.example.android.cactus.data.remote.DictionaryAPI
import com.example.android.cactus.domain.common.Resource
import com.example.android.cactus.domain.model.entity.Translation
import com.example.android.cactus.domain.repository.TranslationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TranslationRepositoryImpl  @Inject constructor(
    private val api: DictionaryAPI,
   // private val dao: WordInfoDao
) : TranslationRepository {

    override fun getTranslation(word: String): Flow<Resource<Translation>> = flow {
        emit(Resource.Loading<Translation>())

        try {
            val translation = api.getSuggestTranslation(
                "dict.1.1.20220319T172823Z.7a3d3eb2d6ee3add.eba6bf6188e808351b661edd0f0f3ca0649b0ad0",
                "ru-en",
                word,
            )

            emit(Resource.Success<Translation>(data = translation.toEntity()))
        } catch (e: HttpException) {
            emit(
                Resource.Error<Translation>(
                    message = "Oops, something went wrong!",
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error<Translation>(
                    message = e.localizedMessage ?: "An unexpected error occured",
                )
            )
        }
    }
}