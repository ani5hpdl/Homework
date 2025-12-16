package com.example.FirstComposeApp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.FirstComposeApp.R
import com.example.FirstComposeApp.repository.UserRepoImpl
import com.example.FirstComposeApp.ui.theme.Purple40
import com.example.FirstComposeApp.ui.theme.PurpleGrey80
import com.example.FirstComposeApp.viewmodel.UserViewModel

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginBody()
        }
    }
}

@Composable
fun LoginBody(){

    var email by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }

    Scaffold() {padding ->
        Column(
            modifier = Modifier.padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Sign In",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.Blue
                ),
                modifier = Modifier.padding(vertical = 50.dp))

            Text("This is nothing just a sample text to make the desgin, it is two line senetence by the way",
                style = TextStyle(
                    textAlign = TextAlign.Center
                ))

            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {
                CardBody(
                    modifier = Modifier.fillMaxWidth().weight(1f).padding(8.dp),
                    R.drawable.facebbook,
                    "Facebook"
                )
                CardBody(
                    modifier = Modifier.fillMaxWidth().weight(1f).padding(8.dp),
                    R.drawable.gmail,
                    "Gmail"
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f).padding(horizontal = 10.dp)
                )
                Text("OR")
                HorizontalDivider(
                    modifier = Modifier.weight(1f).padding(horizontal = 10.dp)
                )
            }

            OutlinedTextField(
                value = email,
                onValueChange = { data ->
                    email = data
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                placeholder = {
                    Text("abc@gmail.com")
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = PurpleGrey80,
                    focusedContainerColor = Purple40,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape(15.dp)

            )

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                placeholder = {
                    Text("***********")
                }
            )

        }
    }
}

@Composable
fun CardBody(modifier: Modifier, Image : Int, label : String ){
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(Image),
                contentDescription = null,
                modifier = Modifier.size(40.dp).padding(horizontal = 10.dp)
            )
            Text(label)
        }
    }
}


@Preview
@Composable
fun LoginPreview(){
    LoginBody()
}