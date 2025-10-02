package com.pdmproyecto.bancoagricolafake.API
import com.pdmproyecto.bancoagricolafake.models.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

interface ApiService {
    @POST("b500efb1-3eff-4a4f-947b-33c80c362877")
    suspend fun login(@Body request: LoginRequest): Response<Unit>
}
