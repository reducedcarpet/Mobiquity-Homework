package net.firestaff.mcp.mobiquityhomework.services

import net.firestaff.mcp.mobiquityhomework.models.Category
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/")
    fun fetchProducts(): Call<List<Category>>
}