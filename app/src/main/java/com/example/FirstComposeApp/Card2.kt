package com.example.FirstComposeApp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun Body(){
    Scaffold() { padding->
        Column(modifier = Modifier.fillMaxSize()
            .padding(padding)
            .background(Color.White))
        {
            Row() {
                Text("Card",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}


@Preview
@Composable
fun MainPreview4(){
    Body()
}