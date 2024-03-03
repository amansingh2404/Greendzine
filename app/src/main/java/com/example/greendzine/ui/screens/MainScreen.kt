package com.example.greendzine.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.greendzine.ui.theme.boxBackgroundColor




data class ScreenDetail(
    var isHome: Boolean = true
)

private var MyObject: ScreenDetail = ScreenDetail()

/**
 * This function create bottomBar and hold the content of HomeScreen() and EmployeeList()
 */
@Composable
fun MyScreen(navController: NavController) {
    Scaffold(
        bottomBar = { MyBottomBar(navController) },
        modifier = Modifier
            .background(Color.Black),
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding),
        ) {
            // Your screen content goes here
            if(MyObject.isHome){
                HomeScreen()
            }
            else
            {
                EmployeeListScreen()
            }

        }
    }
}

@Composable
fun MyBottomBar(navController: NavController  ) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(1f)
            .background(Color.Black)



    ) {
        FloatingActionButton(onClick = { navController.navigate("home_screen")
                       MyObject.isHome = true },
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
        ) {
            Icon(imageVector = Icons.Default.Home,
                contentDescription ="",
                        modifier = Modifier
                        .size(10.dp)
                        .background(boxBackgroundColor),)

        }

       FloatingActionButton(onClick = { navController.navigate("list_screen")
                         MyObject.isHome = false},
           modifier = Modifier
               .height(35.dp)
               .width(35.dp)

            ) {
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "Employee List",
                modifier = Modifier
                    .size(10.dp)
                    .background(boxBackgroundColor),
            )
            
        }
    }
}







