package com.example.greendzine.ui.auth.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greendzine.R
import com.example.greendzine.ui.auth.UserDetails
import com.example.greendzine.ui.components.MyTextField
import com.example.greendzine.ui.components.NormalTextComponents
import com.example.greendzine.ui.theme.normalTextColor
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration


/**
 * This function saves details on Realm Local data base during sign Up
 * We can use this data to validate user during Login
 * because this Application doesn't include sign out we don't need Login.
 */
fun saveDetails(name: String, userEmail: String, userPassword: String){

    val config = RealmConfiguration.create(schema = setOf(UserDetails::class))
    val realm: Realm = Realm.open(config)

    realm.writeBlocking {
        copyToRealm(
            UserDetails().apply {
                userName = name
                email = userEmail
                password = userPassword

            }
        )
    }
}

/**
 * Sign Up function to take userName, UserEmail and password and store it into Local database
 */
@Composable
fun SignUpScreen(onClick: () ->Unit){
    var userName :String = ""
    var userEmail :String = ""
    var userPassword :String = ""

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription ="Logo",
            modifier = Modifier
                .padding(top = 100.dp)
                .size(60.dp)
        )

        NormalTextComponents(value = "We are Electric", normalTextColor)

        Column(
            modifier = Modifier
                .padding(top = 40.dp)
                .background(Color.Black),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,


            ){
           userName =  MyTextField(labelValue = "Name")
           userEmail =  MyTextField(labelValue = "e-mail")
          userPassword =   MyTextField(labelValue = "password")
        }
        Button(onClick = {

                         saveDetails(userName, userEmail,userPassword)
                            onClick()
                         },
            modifier = Modifier
                .padding(top = 20.dp)
                .width(100.dp),
            colors = ButtonDefaults.buttonColors(normalTextColor),
            shape = RoundedCornerShape(20.dp)

        ) {
            Text(text = "Sign Up")
        }
    }

}




@Preview(showSystemUi = true)
@Composable
fun SignUpPreview(){

}
