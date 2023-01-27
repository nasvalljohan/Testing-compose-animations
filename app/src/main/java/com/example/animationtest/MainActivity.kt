package com.example.animationtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var sizeState by remember {
                mutableStateOf(200.dp)
            }
            val size by animateDpAsState(
                targetValue = sizeState,
                tween(
                    durationMillis = 500
                )
            )

            val infiniteTransition = rememberInfiniteTransition()
            val color by infiniteTransition.animateColor(
                initialValue = Color.Red,
                targetValue = Color.Green,
                animationSpec = infiniteRepeatable(
                    tween(2000),
                    repeatMode = RepeatMode.Reverse
                )
            )

           Box(modifier = Modifier
               .size(size)
               .background(color), contentAlignment = Alignment.Center) {
               Button(onClick = {
                   sizeState += 50.dp
               }) {
                   Text(text = "Increase size")
               }
           }
        }
    }
}

