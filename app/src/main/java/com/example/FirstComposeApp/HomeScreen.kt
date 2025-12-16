package com.example.FirstComposeApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen1(){

    var data = listOf( R.drawable.watch, R.drawable.shoes, R.drawable.airpods, R.drawable.watch, R.drawable.shoes, R.drawable.airpods)
    var dataName = listOf("Watch","Shoes","Airpods","Watch","Shoes","Airpods")

    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color.White),
    ) {
        item {
            Image(
                painter = painterResource(R.drawable.banner),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(100.dp),
                contentScale = ContentScale.Crop
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(data.size){ index->
                    Column() {
                        Image(
                            painter = painterResource(data[index]),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp).padding(end = 10.dp)
                        )
                        Text(dataName[index])
                    }
                }
            }
        }



    }
}

@Preview
@Composable
fun HomePrev(){
    HomeScreen1()
}