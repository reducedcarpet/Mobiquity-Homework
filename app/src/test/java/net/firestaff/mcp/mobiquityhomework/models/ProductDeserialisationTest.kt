package net.firestaff.mcp.mobiquityhomework.models

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test

val testJson = """{
    "id": "2",
    "categoryId": "36802",
    "name": "Sandwich",
    "url": "/Sandwich.jpg",
    "description": "A sandwich",
    "salePrice": {
        "amount": "2.01",
        "currency": "EUR"
    }
}"""

val listJson = """[{
    "id": "2",
    "categoryId": "36802",
    "name": "Sandwich",
    "url": "/Sandwich.jpg",
    "description": "A sandwich",
    "salePrice": {
        "amount": "2.01",
        "currency": "EUR"
    }
}, {
    "id": "2",
    "categoryId": "36802",
    "name": "Sandwich",
    "url": "/Sandwich.jpg",
    "description": "A sandwich",
    "salePrice": {
        "amount": "2.01",
        "currency": "EUR"
    }
}, {
    "id": "2",
    "categoryId": "36802",
    "name": "Sandwich",
    "url": "/Sandwich.jpg",
    "description": "A sandwich",
    "salePrice": {
        "amount": "2.01",
        "currency": "EUR"
    }
}]"""

val emptyJson = """{
    "id": "",
    "categoryId": "",
    "name": "",
    "url": "",
    "description": "",
    "salePrice": {
        "amount": "",
        "currency": ""
    }
}"""

val numberJson = """{
    "id": 2,
    "categoryId": 36802,
    "name": "Sandwich",
    "url": "/Sandwich.jpg",
    "description": "A sandwich",
    "salePrice": {
        "amount": 2.01,
        "currency": "EUR"
    }
}"""

val trueEmptyJson = """{
    "id": ""
}"""

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 */
class ProductDeserializationTest {

    private val gson = Gson()

    @Test
    fun deserialization_is_correct() {
        val product = gson.fromJson(testJson, Product::class.java)
        assertTrue(product is Product)
        assertTrue(product.id == "2")
        assertTrue(product.categoryId == "36802")
        assertTrue(product.name == "Sandwich")
        assertTrue(product.url == "/Sandwich.jpg")
        assertTrue(product.description == "A sandwich")
        assertTrue(product.salePrice.amount == "2.01")
        assertTrue(product.salePrice.currency == "EUR")
    }

    @Test
    fun list_deserialization_is_correct() {
        val type = object : TypeToken<List<Product>>() {}.type
        val products = gson.fromJson<List<Product>>(listJson, type)
        assertTrue(products is List<Product>)
        assertTrue(products.size == 3)
    }

    @Test
    fun empty_deserialization_does_not_error() {
        val product = gson.fromJson(emptyJson, Product::class.java)
        assertTrue(product is Product)
        assertTrue(product.id == "")
        assertTrue(product.categoryId == "")
        assertTrue(product.name == "")
        assertTrue(product.url == "")
        assertTrue(product.description == "")
        assertTrue(product.salePrice.amount == "")
        assertTrue(product.salePrice.currency == "")
    }

    @Test
    fun true_empty_deserialization_does_not_error() {
        var exceptionThrown = false
        try {
            gson.fromJson(trueEmptyJson, Product::class.java)
        } catch (e: JsonSyntaxException) {
            exceptionThrown = true
        }

        Assert.assertFalse(exceptionThrown)
    }
}