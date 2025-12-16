//package com.example.FirstComposeApp
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.FirstComposeApp.ui.theme.ParrotGreen
//
//@Composable
//fun Card(){
//    Scaffold() { padding ->
//        Column(
//            modifier = Modifier.fillMaxSize()
//                .padding(padding)
//                .background(ParrotGreen)
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.End
//            ) {
//                Image(
//                    painter = painterResource(R.drawable.img),
//                    contentDescription = null,
//                    modifier = Modifier.clip(CircleShape).size(50.dp),
//                    contentScale = ContentScale.Crop
//                    )
//            }
//            Column () {
//                Text("Card",
//                    color = Color.White,
//                    fontSize = 30.sp
//                    )
//                Text("Simple and easy to use app",
//                    color = Color.White,
//                    fontSize = 15.sp)
//            }
//            Row(
//                modifier = Modifier.padding(10.dp)
//            ) {
//                Card(
//                    modifier = Modifier
//                        .height(170.dp)
//                        .weight(1f),
//                    colors = CardDefaults.cardColors(
//                        contentColor = Color.White
//                    ),
//                    elevation = CardDefaults.cardElevation(
//                        defaultElevation = 10.dp
//                    ),
//                    shape = RoundedCornerShape(15.dp)
//                ) {
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Image(
//                            painter = painterResource(R.drawable.img),
//                            contentDescription = null,
//                        )
//                        Text("ABCD",
//                            color = Color.Black,
//                            modifier = Modifier.padding(10.dp))
//                    }
//                }
//                Spacer(
//                    modifier = Modifier.width(20.dp)
//                )
//                Card(
//                    modifier = Modifier
//                        .height(170.dp)
//                        .weight(1f),
//                    colors = CardDefaults.cardColors(
//                        contentColor = Color.White
//                    ),
//                    elevation = CardDefaults.cardElevation(
//                        defaultElevation = 10.dp
//                    ),
//                    shape = RoundedCornerShape(15.dp)
//                ) {
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Image(
//                            painter = painterResource(R.drawable.img),
//                            contentDescription = null,
//                        )
//                        Text("ABCD",
//                            color = Color.Black,
//                            modifier = Modifier.padding(10.dp))
//                    }
//                }
//            }
//            Row(
//                modifier = Modifier.padding(10.dp)
//            ) {
//                Card(
//                    modifier = Modifier
//                        .height(170.dp)
//                        .weight(1f),
//                    colors = CardDefaults.cardColors(
//                        contentColor = Color.White
//                    ),
//                    elevation = CardDefaults.cardElevation(
//                        defaultElevation = 10.dp
//                    ),
//                    shape = RoundedCornerShape(15.dp)
//                ) {
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Image(
//                            painter = painterResource(R.drawable.img),
//                            contentDescription = null,
//                        )
//                        Text("ABCD",
//                            color = Color.Black,
//                            modifier = Modifier.padding(10.dp))
//                    }
//                }
//                Spacer(
//                    modifier = Modifier.width(20.dp)
//                )
//                Card(
//                    modifier = Modifier
//                        .height(170.dp)
//                        .weight(1f),
//                    colors = CardDefaults.cardColors(
//                        contentColor = Color.White
//                    ),
//                    elevation = CardDefaults.cardElevation(
//                        defaultElevation = 10.dp
//                    ),
//                    shape = RoundedCornerShape(15.dp)
//                ) {
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Image(
//                            painter = painterResource(R.drawable.img),
//                            contentDescription = null,
//                        )
//                        Text("ABCD",
//                            color = Color.Black,
//                            modifier = Modifier.padding(10.dp))
//                    }
//                }
//            }
//            Row(
//                modifier = Modifier.padding(10.dp)
//            ) {
//                Card(
//                    modifier = Modifier
//                        .height(170.dp)
//                        .weight(1f),
//                    colors = CardDefaults.cardColors(
//                        contentColor = Color.White
//                    ),
//                    elevation = CardDefaults.cardElevation(
//                        defaultElevation = 10.dp
//                    ),
//                    shape = RoundedCornerShape(15.dp)
//                ) {
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Image(
//                            painter = painterResource(R.drawable.img),
//                            contentDescription = null,
//                        )
//                        Text("ABCD",
//                            color = Color.Black,
//                            modifier = Modifier.padding(10.dp))
//                    }
//                }
//                Spacer(
//                    modifier = Modifier.width(20.dp)
//                )
//                Card(
//                    modifier = Modifier
//                        .height(170.dp)
//                        .weight(1f),
//                    colors = CardDefaults.cardColors(
//                        contentColor = Color.White
//                    ),
//                    elevation = CardDefaults.cardElevation(
//                        defaultElevation = 10.dp
//                    ),
//                    shape = RoundedCornerShape(15.dp)
//                ) {
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Image(
//                            painter = painterResource(R.drawable.img),
//                            contentDescription = null,
//                        )
//                        Text("ABCD",
//                            color = Color.Black,
//                            modifier = Modifier.padding(10.dp))
//                    }
//                }
//            }
//            Card(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(10.dp),
//                elevation = CardDefaults.cardElevation(
//                    defaultElevation = 10.dp
//                ),
//            ) {
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//
//                ){
//                    Icon(
//                        painter = painterResource(R.drawable.baseline_settings_24),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(80.dp)
//                            .padding(20.dp)
//                            .fillMaxSize())
//                    Column(
//                        modifier = Modifier.padding(0.dp, 20.dp)
//                    ) {
//                        Text("Settings",
//                            fontSize = 25.sp)
//                        Text("qwertyuiopasdfghjklzxcvbnm")
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//fun MainPreview(){
//    Card()
//}
