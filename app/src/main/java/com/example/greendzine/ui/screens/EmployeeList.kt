package com.example.greendzine.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.greendzine.R
import com.example.greendzine.model.Employee
import com.example.greendzine.ui.components.MyTextField
import com.example.greendzine.ui.components.NormalTextComponents
import com.example.greendzine.ui.theme.boxBackgroundColor
import com.example.greendzine.ui.theme.normalTextColor


/**
 * This function take employeeDetails: Employee as parameter and present it on screen
 */

@Composable
fun PrintDetails(employeeDetail: Employee){
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(10.dp)
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(boxBackgroundColor)
                .padding(10.dp)


        ) {
            NormalTextComponents(value = "EmployeeId:  ${employeeDetail.employeeId}", color = normalTextColor)
            NormalTextComponents(value = "Name:  ${employeeDetail.name}", color = normalTextColor )
            NormalTextComponents(value = "DOB:  ${employeeDetail.DOB}", color = normalTextColor )
            NormalTextComponents(value = "Role:  ${employeeDetail.Role}", color = normalTextColor )
        }

    }

}

/**
 * This Function gets EmployeeList form EmployeeListViewModel and present data on screen using
 * LazyColumn.
 */

@Composable
fun EmployeeListScreen(){
Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.background(Color.Black)
) {

    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .padding(start = 330.dp)
            .padding(top = 10.dp)
            .background(Color.Black)

    ) {
        Image(
            painter = painterResource(id = R.drawable.group),
            contentDescription ="",
            modifier = Modifier
                .size(50.dp),
            alignment = Alignment.TopEnd
        )
    }



    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.moptro_logo),
            contentDescription ="",
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(bottom = 10.dp)
                .size((80.dp))
                .background(Color.Black)
        )

       var userInput =  MyTextField(labelValue = "search employee name")

        val context = LocalContext.current
        val viewModel: EmployeeListViewModel = viewModel(factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(EmployeeListViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return EmployeeListViewModel(context) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        })

        val employeeList = viewModel.getEmployees()



        if(userInput == ""){
            LazyColumn(contentPadding = PaddingValues(16.dp)){

                items(employeeList){
                        employee->
                    PrintDetails(employeeDetail = employee)
                }
            }
        }
        else if(  userInput != ""){
            SearchUser(name = userInput)
        }


    }
}


}

/**
 * This function take name: String as parameter, search that name in employeeList
 * and present it on screen.
 */

@Composable
fun SearchUser(name: String){
    val context = LocalContext.current
    val viewModel: EmployeeListViewModel = viewModel(factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EmployeeListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return EmployeeListViewModel(context) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    })

    val employeeList = viewModel.getEmployees()

    for (employee in employeeList){
        if (employee.name == name){
            PrintDetails(employeeDetail = employee)
            return
        }
    }
    NormalTextComponents(value = "User Not Found", color = normalTextColor )

}


@Preview(showSystemUi = true)
@Composable
fun EmployeeListPreview(){
    EmployeeListScreen()
}