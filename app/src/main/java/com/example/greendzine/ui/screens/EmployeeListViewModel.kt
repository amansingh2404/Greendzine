package com.example.greendzine.ui.screens

import android.app.Application
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.greendzine.model.Employee
import com.example.greendzine.model.getEmployeesFromAssets

/**
 * EmployeeListViewModel class to get data from json object and render it on UI.
 */
class EmployeeListViewModel(application: Context) : ViewModel() {
    private val employeeList = getEmployeesFromAssets(application)

    fun getEmployees(): List<Employee> {
        return employeeList
    }
}


