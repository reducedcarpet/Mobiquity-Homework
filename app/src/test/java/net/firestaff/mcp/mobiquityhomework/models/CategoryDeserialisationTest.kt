package net.firestaff.mcp.mobiquityhomework.models

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

val categoryTestJson = """{
		"id": "36802",
		"name": "Food",
		"description": "",
		"products": [{
			"id": "1",
			"categoryId": "36802",
			"name": "Bread",
			"url": "/Bread.jpg",
			"description": "",
			"salePrice": {
				"amount": "0.81",
				"currency": "EUR"
			}
		},{
			"id": "2",
			"categoryId": "36802",
			"name": "Sandwich",
			"url": "/Sandwich.jpg",
			"description": "",
			"salePrice": {
				"amount": "2.01",
				"currency": "EUR"
			}
		},{
			"id": "3",
			"categoryId": "36802",
			"name": "Milk",
			"url": "/Milk.jpg",
			"description": "",
			"salePrice": {
				"amount": "2.00",
				"currency": "EUR"
			}
		},{
			"id": "4",
			"categoryId": "36802",
			"name": "Cake",
			"url": "/Cake.jpg",
			"description": "",
			"salePrice": {
				"amount": "0.01",
				"currency": "EUR"
			}
		}]
}"""

val categoryListJson =  """[{
		"id": "36802",
		"name": "Food",
		"description": "",
		"products": [{
			"id": "1",
			"categoryId": "36802",
			"name": "Bread",
			"url": "/Bread.jpg",
			"description": "",
			"salePrice": {
				"amount": "0.81",
				"currency": "EUR"
			}
		},{
			"id": "2",
			"categoryId": "36802",
			"name": "Sandwich",
			"url": "/Sandwich.jpg",
			"description": "",
			"salePrice": {
				"amount": "2.01",
				"currency": "EUR"
			}
		},{
			"id": "3",
			"categoryId": "36802",
			"name": "Milk",
			"url": "/Milk.jpg",
			"description": "",
			"salePrice": {
				"amount": "2.00",
				"currency": "EUR"
			}
		},{
			"id": "4",
			"categoryId": "36802",
			"name": "Cake",
			"url": "/Cake.jpg",
			"description": "",
			"salePrice": {
				"amount": "0.01",
				"currency": "EUR"
			}
		}]
},{
		"id": "36803",
		"name": "Drink",
		"description": "",
		"products": [{
			"id": "1",
			"categoryId": "36803",
			"name": "Cola",
			"url": "/Cola.jpg",
			"description": "",
			"salePrice": {
				"amount": "0.81",
				"currency": "EUR"
			}
		},{
			"id": "2",
			"categoryId": "36803",
			"name": "Fanta",
			"url": "/Fanta.jpg",
			"description": "",
			"salePrice": {
				"amount": "2.01",
				"currency": "EUR"
			}
		},{
			"id": "3",
			"categoryId": "36803",
			"name": "Juice",
			"url": "/Juice.jpg",
			"description": "",
			"salePrice": {
				"amount": "2.00",
				"currency": "EUR"
			}
		},{
			"id": "4",
			"categoryId": "36803",
			"name": "Beer",
			"url": "/Beer.jpg",
			"description": "",
			"salePrice": {
				"amount": "0.01",
				"currency": "EUR"
			}
		}]
}]"""

val emptyCategoryJson = """{
    "id": "",
    "name": "",
    "description": "",
    "products": []
}"""

val trueEmptyCategoryJson = """{
    "id": ""
}"""

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 */
class CategoryDeserializationTest {

    private val gson = Gson()

    @Test
    fun deserialization_is_correct() {
        val category = gson.fromJson(categoryTestJson, Category::class.java)
        assertTrue(category is Category)
        assertTrue(category.id == "36802")
        assertTrue(category.name == "Food")
        assertTrue(category.description == "")
        assertTrue(category.products.size == 4)
    }

    @Test
    fun list_deserialization_is_correct() {
        val type = object : TypeToken<List<Category>>() {}.type
        val categories = gson.fromJson<List<Category>>(categoryListJson, type)
        assertTrue(categories is List<Category>)
        assertTrue(categories.size == 2)
    }

    @Test
    fun empty_deserialization_does_not_error() {
        val category = gson.fromJson(emptyCategoryJson, Category::class.java)
        assertTrue(category is Category)
        assertTrue(category.id == "")
        assertTrue(category.name == "")
        assertTrue(category.description == "")
    }

    @Test
    fun true_empty_deserialization_does_not_error() {
        var exceptionThrown = false
        try {
            gson.fromJson(trueEmptyCategoryJson, Category::class.java)
        } catch (e: JsonSyntaxException) {
            exceptionThrown = true
        }

        assertFalse(exceptionThrown)
    }
}