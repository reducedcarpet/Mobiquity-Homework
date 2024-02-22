package net.firestaff.mcp.mobiquityhomework.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.firestaff.mcp.mobiquityhomework.models.Category
import net.firestaff.mcp.mobiquityhomework.services.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryViewModel : ViewModel() {
    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = _categories

    fun fetchCategories() {
        RetrofitClient.retrofitInstance.fetchProducts()
            .enqueue(object : Callback<List<Category>> {
                override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                    if (response.isSuccessful) {
                        _categories.postValue(response.body())
                    } else {
                        // Handle error
                        println("Error: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                    // Handle failure
                    println("Failure: ${t.message}")
                }
            })
    }
}