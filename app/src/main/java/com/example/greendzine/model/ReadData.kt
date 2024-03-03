package com.example.greendzine.model

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

/**
 * This Function reads the json data and return it into json Object
 * that will be accessed by ViewModel.
 */
fun getEmployeesFromAssets(context: Context): List<Employee> {
    val fileName = "employees.json" // Replace with your actual file name
    val jsonString: String = try {
        context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (e: IOException) {
        Log.e("Error", "Failed to read JSON file: $e")
        return emptyList()
    }
    return Gson().fromJson(jsonString, object : TypeToken<List<Employee>>() {}.type)
}
