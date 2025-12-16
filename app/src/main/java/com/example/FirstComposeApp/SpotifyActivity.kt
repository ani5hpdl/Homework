package com.example.FirstComposeApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Spotify(){
    Scaffold() { padding->
        Column(
            modifier = Modifier.padding(padding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Recently Played",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.width(150.dp)
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(painter = painterResource(R.drawable.baseline_notifications_24),
                        contentDescription = null)
                    Icon(painter = painterResource(R.drawable.baseline_history_24),
                        contentDescription = null)
                    Icon(painter = painterResource(R.drawable.baseline_settings_24),
                        contentDescription = null)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier.size(120.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop

                    )
                    Text("Lana Del Rey",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier.size(120.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop

                    )
                    Text("Marvin Gaye",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.img),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Column(modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)) {
                    Text("#SPOTIFYWRAPPED")
                    Text("YOUR 2021 in Review",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold)
                }
            }
            Row(
                modifier = Modifier.padding(10.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier.size(180.dp)
                    )
                    Text("Your Top Songs 2021",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier.size(180.dp)
                    )
                    Text("Your Top Songs 2021",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                }
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Text("Editor's Choice!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold)
                Row() {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.img),
                            contentDescription = null,
                            modifier = Modifier.size(180.dp)
                        )
                        Text("Your Top Songs 2021",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.img),
                            contentDescription = null,
                            modifier = Modifier.size(180.dp)
                        )
                        Text("Your Top Songs 2021",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MainPreview3(){
    Spotify()
}