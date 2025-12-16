package com.example.FirstComposeApp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.FirstComposeApp.ui.theme.Purple40


@Composable
fun ProfileScreen(){
    Scaffold { padding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth()
                , horizontalArrangement = Arrangement.SpaceBetween
                , verticalAlignment = Alignment.CenterVertically
                ,
            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_arrow_back_ios_new_24),
                    contentDescription = null
                )
                Text("Itsmeanish635")
                Icon(
                    painter = painterResource(R.drawable.outline_apps_24),
                    contentDescription = null
                )   
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Image(
                    painter = painterResource(R.drawable.img),
                    contentDescription = "A image",
                    alignment = Alignment.Center,
                    modifier = Modifier.height(100.dp)
                        .width(100.dp).clip(
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("0,000")
                    Text("Posts")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("0,000")
                    Text("Followers")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("0,000")
                    Text("Followings")
                }
            }
            Column(
                modifier = Modifier.
                padding(20.dp, 0.dp)
            ) {
                Text("Username")
                Text("hjrf")
                Text("hjrf")
                Text("hjrf")
                Text("hjrf")
                Text("Followed by me n u")
                Button(onClick = {},
                        modifier = Modifier.
                        fillMaxWidth(),
                        shape = RectangleShape
                    ) {
                    Text("Button")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = {},
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    border = BorderStroke(2.dp, Purple40)
                ) {
                    Text("Follow")
                }
                Button(onClick = {}) {
                    Text("Message")
                }
                Button(onClick = {},
                    ) {
                    Text("Email")
                }
                Button(onClick = {},
                        modifier = Modifier.width(60.dp)
                    ) {
                    Image(
                        painter = painterResource(R.drawable.outline_arrow_drop_down_24),
                        contentDescription = null
                    )
                }

            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier.clip(shape = CircleShape).width(70.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text("Story 1")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier.clip(shape = CircleShape).width(70.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text("Story 2")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier.clip(shape = CircleShape).width(70.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text("Story 3")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier.clip(shape = CircleShape).width(70.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text("Story 4")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier.clip(shape = CircleShape).width(70.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text("Story 5")
                }

            }


        }
    }
}

@Preview
@Composable
fun MainPreview2(){
    ProfileScreen()
}