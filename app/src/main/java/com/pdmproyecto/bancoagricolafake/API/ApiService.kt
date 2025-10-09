package com.pdmproyecto.bancoagricolafake.API
import com.pdmproyecto.bancoagricolafake.models.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

interface ApiService {
    @POST(".")
    suspend fun login(@Body request: LoginRequest): Response<Unit>
}
