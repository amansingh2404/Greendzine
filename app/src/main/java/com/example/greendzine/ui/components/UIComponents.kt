package com.example.greendzine.ui.components

import android.widget.ProgressBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greendzine.ui.theme.normalTextColor
import com.example.greendzine.ui.theme.textFieldColor

@Composable
fun NormalTextComponents(value: String, color: Color){
    Text(
        text = value,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
        ),
        color = color,
        textAlign = TextAlign.Center

        )
}

@Composable
fun MyTextField(labelValue: String): String{
    var textValue by rememberSaveable{
        mutableStateOf("")
    }
    TextField(
        value = textValue,

        onValueChange = { textValue = it },
        label = {
            Text(
                labelValue,
                color = normalTextColor
            )
        },
        singleLine = true,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(textFieldColor),
    )
return  textValue
}

@Composable
fun ProgressBar(progress: Float){
    LinearProgressIndicator(
        progress = progress,
        modifier = Modifier
            .width(270.dp) // Adjust width as needed
            .height(15.dp)
            .clip(RoundedCornerShape(8.dp)),
        // Set the height of the progress bar
        color = normalTextColor, // Customize the progress color

    )
}


@Preview(showSystemUi = true)
@Composable
fun Preview(){
ProgressBar(progress = 0.5f)
}