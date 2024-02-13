package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.basiccompose.ui.theme.BasicComposeTheme
import androidx.compose.material3.Button as MyButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicComposeTheme {
                ImagesChanging(
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun ImagesChanging(
    modifier: Modifier = Modifier
        .fillMaxWidth()
) {
    var index by remember {
        mutableStateOf(0)
    }
    val images = listOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3
    )
    Row(

    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(2.dp,top=2.dp)
        ) {
            Image(
                painter = painterResource(id = images[index]),
                contentDescription = "Image"
            )
        }
    }
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(30.dp)
        )
    {
        MyButton(
            onClick = {
                index = (index + 1) % images.size
            },
        ) {
            Text(text = "Next")
        }
    }
}

