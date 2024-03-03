package com.example.greendzine.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greendzine.R
import com.example.greendzine.ui.components.NormalTextComponents
import com.example.greendzine.ui.components.ProgressBar
import com.example.greendzine.ui.theme.boxBackgroundColor
import com.example.greendzine.ui.theme.normalTextColor


/**
 * This Function present Employee Productivity data on screen
 */
@Composable
fun HomeScreen() {

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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.moptro_logo),
                contentDescription ="",
                modifier = Modifier
                    .padding(top = 25.dp)
                    .size((80.dp))
                    .background(Color.Black)
                )
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(boxBackgroundColor),
                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier
                    .padding(top = 30.dp)
                    .background(Color.Black)
                    .fillMaxSize()



            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Card(
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(text = "Employee Productivity Dashboard",
                            style = TextStyle(
                                fontSize = 20.sp,
                            ),
                            color = Color.White,
                            modifier = Modifier
                                .background(boxBackgroundColor)
                                .padding(10.dp)

                        )

                    }

                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .padding(top = 8.dp)

                    ) {
                            NormalTextComponents(value = "Productivity on Monday", color = normalTextColor)
                            Row(
                            ) {
                                ProgressBar(progress = 0.02f)

                                NormalTextComponents(value = "2%", color = normalTextColor)
                            }
                    }

                    Column(
                        modifier = Modifier
                    ) {
                        NormalTextComponents(value = "Productivity on Tuesday", color = normalTextColor)
                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            ProgressBar(progress = 0.2f)
                            Spacer(modifier = Modifier.padding(start = 5.dp))
                            NormalTextComponents(value = "20%", color = normalTextColor)
                        }
                    }
                    Column(

                    ) {
                        NormalTextComponents(value = "Productivity on Wednesday", color = normalTextColor)
                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            ProgressBar(progress = 0.9f)
                            Spacer(modifier = Modifier.padding(start = 5.dp))
                            NormalTextComponents(value = "90%", color = normalTextColor)
                        }
                    }
                    Column(

                    ) {
                        NormalTextComponents(value = "Productivity on Thursday", color = normalTextColor)
                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            ProgressBar(progress = 1.2f)
                            Spacer(modifier = Modifier.padding(start = 5.dp))
                            NormalTextComponents(value = "120%", color = normalTextColor)
                        }
                    }
                    Column(

                    ) {
                        NormalTextComponents(value = "Productivity on Monday", color = normalTextColor)
                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            ProgressBar(progress = 0.8f)
                            Spacer(modifier = Modifier.padding(start = 5.dp))
                            NormalTextComponents(value = "80%", color = normalTextColor)
                        }
                    }
                    Column(

                    ) {
                        NormalTextComponents(value = "Productivity on Saturday", color = normalTextColor)
                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            ProgressBar(progress = 0.93f)
                            Spacer(modifier = Modifier.padding(start = 5.dp))
                            NormalTextComponents(value = "93%", color = normalTextColor)
                        }
                    }
                }

            }
        }
    }




}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview(){
HomeScreen()
}
