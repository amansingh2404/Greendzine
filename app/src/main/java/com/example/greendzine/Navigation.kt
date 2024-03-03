package com.example.greendzine

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greendzine.ui.auth.UserDetails
import com.example.greendzine.ui.auth.signup.SignUpScreen
import com.example.greendzine.ui.screens.EmployeeListScreen
import com.example.greendzine.ui.screens.HomeScreen
import com.example.greendzine.ui.screens.MyScreen
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults

/**
 * This function is used for navigation through screen using navController
 */

@Composable
fun MyApplication(){
    val navController = rememberNavController()
    val config = RealmConfiguration.create(schema = setOf(UserDetails::class))
    val realm: Realm = Realm.open(config)
    val items: RealmResults<UserDetails> = realm.query<UserDetails>().find()
    var route: String = ""
    if(items.isEmpty()){
        route = "sign_up"
    }
    else{
        route = "main_screen"
    }
    NavHost(navController = navController, startDestination = route ){
        composable(route = "sign_up"){
            SignUpScreen{
                navController.navigate("main_Screen")
            }
        }
        composable(route = "main_screen"){
            MyScreen(navController)
        }
        composable(route = "home_screen"){
            HomeScreen()
        }
        composable(route = "list_screen"){
            EmployeeListScreen()
        }
    }

}