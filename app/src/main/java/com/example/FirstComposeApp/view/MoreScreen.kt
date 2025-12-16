package com.example.FirstComposeApp.view

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.FirstComposeApp.DashboardActivity
import com.example.FirstComposeApp.model.ProductModel
import com.example.FirstComposeApp.model.UserModel
import com.example.FirstComposeApp.repository.ProductRepoImpl
import com.example.FirstComposeApp.ui.theme.Purple40
import com.example.FirstComposeApp.ui.theme.PurpleGrey80
import com.example.FirstComposeApp.viewmodel.ProductViewModel

@Composable
fun MoreScreen(){

    var productName by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
    var productRate by remember { mutableStateOf("") }

    val context = LocalContext.current

    val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
    ) {

        Text("Product Name:",
            modifier = Modifier.padding(15.dp),
            style = TextStyle(
                color = Color.White,
                fontSize = 15.sp
            )
        )
        OutlinedTextField(
            value = productName,
            onValueChange = { data ->
                productName = data
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            placeholder = {
                Text("Enter te Product Name: ")
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = PurpleGrey80,
                focusedContainerColor = PurpleGrey80,
                focusedIndicatorColor = Color.Blue,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            shape = RoundedCornerShape(15.dp)

        )

        Text("Product Quantity:",
            modifier = Modifier.padding(15.dp),
            style = TextStyle(
                color = Color.White,
                fontSize = 15.sp
            )
        )

        OutlinedTextField(
            value = productQuantity,
            onValueChange = {
                productQuantity = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = {
                Text("Enter te Product Quantity: ")
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = PurpleGrey80,
                focusedContainerColor = PurpleGrey80,
                focusedIndicatorColor = Color.Blue,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            shape = RoundedCornerShape(15.dp)

        )
        Text("Product Rate:",
            modifier = Modifier.padding(15.dp),
            style = TextStyle(
                color = Color.White,
                fontSize = 15.sp
            )
        )
        OutlinedTextField(
            value = productRate,
            onValueChange = { data ->
                productRate = data
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = {
                Text("Enter te Product Rate: ")
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = PurpleGrey80,
                focusedContainerColor = PurpleGrey80,
                focusedIndicatorColor = Color.Blue,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            shape = RoundedCornerShape(15.dp)

        )

        Button(onClick = {

                    val model = ProductModel(
                        productName = productName,
                        productQuantity = productQuantity,
                        productRate = productRate
                    )
                    productViewModel.addProduct(model){
                            success,message->
                        if(success){
                            Toast.makeText(context,
                                message,
                                Toast.LENGTH_LONG
                            ).show()
                            val intent = Intent(
                                context,
                                DashboardActivity::class.java
                            )
                            context.startActivity(intent)
                        }else{
                            Toast.makeText(context,
                                message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
        },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            )
        ) {
            Text("Add Product")
        }
    }
}