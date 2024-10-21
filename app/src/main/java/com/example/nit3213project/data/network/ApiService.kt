package com.example.nit3213project.data.network

import com.example.nit3213project.data.model.DashboardResponse
import com.example.nit3213project.data.model.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("/footscray/auth")
    fun login(@Body loginRequest: LoginRequest): Call<Map<String, String>>

    @GET("/dashboard/{keypass}")
    fun getDashboardData(@Path("keypass") keypass: String): Call<DashboardResponse>
}
