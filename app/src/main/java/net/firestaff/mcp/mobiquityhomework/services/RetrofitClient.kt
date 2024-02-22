package net.firestaff.mcp.mobiquityhomework.services

import net.firestaff.mcp.mobiquityhomework.data.AWS_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofitInstance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(AWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}