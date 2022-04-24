package com.example.moviesapp.ui.home.repository

import com.example.moviesapp.model.State
import com.example.moviesapp.networking.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MoviesRepository {

     fun getPopular()= wrapWithFlow{ API.apiServi.getPopularMovies("2f39f3ebb0f35d03248e81aa868bfd36")}
    fun getTop()= wrapWithFlow{ API.apiServi.getTopRated("2f39f3ebb0f35d03248e81aa868bfd36")}
    fun getUp()= wrapWithFlow{ API.apiServi.getUpComing("2f39f3ebb0f35d03248e81aa868bfd36")}





    fun <T> wrapWithFlow(function : suspend () -> Response<T>): Flow<State<T?>>{
        return flow {
            emit(State.Loading)
            try {
                val result = function()
                if (result.isSuccessful) {
                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error(result.message()))
                }
            }catch (e : Exception){
                emit(State.Error(e.message.toString()))
            }
        }
    }
}
