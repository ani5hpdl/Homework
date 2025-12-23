package com.example.FirstComposeApp.view

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.FirstComposeApp.R
import com.example.FirstComposeApp.model.ProductModel
import com.example.FirstComposeApp.repository.ProductRepoImpl
import com.example.FirstComposeApp.ui.theme.PurpleGrey80
import com.example.FirstComposeApp.viewmodel.ProductViewModel
import kotlin.collections.emptyList

@Composable
fun HomeScreen1(){
    val context = LocalContext.current

    val productViewModel = remember() { ProductViewModel(ProductRepoImpl()) }

    var pName by remember { mutableStateOf("") }
    var pQuantity by remember { mutableStateOf("") }
    var pRate by remember { mutableStateOf("") }

    val products = productViewModel.products.observeAsState(initial = null)

    LaunchedEffect(products.value) {
        productViewModel.getAllProduct()

        products.value?.let{
            pName = it.productName
            pQuantity = it.productQuantity
            pRate = it.productRate
        }
    }

    val allproducts = productViewModel.allProducts.observeAsState(initial = emptyList())

    val loading = productViewModel.loading.observeAsState(initial = false)

    var showDialog by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {

        item{
            if(showDialog){
                AlertDialog(
                    onDismissRequest = {
                        showDialog = false
                    },
                    confirmButton = {
                        TextButton(onClick = {
                            var model = ProductModel(
                                products.value!!.productId,
                                pName,
                                pQuantity,
                                pRate
                            )
                            productViewModel.updateProduct(model){
                                    success,message->
                                if(success){
                                    showDialog = false
                                    Toast.makeText(context,
                                        message,
                                        Toast.LENGTH_LONG
                                    ).show()
                                }else{
                                    Toast.makeText(context,
                                        message,
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                        }) {
                            Text("Update")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            showDialog = false
                        }) {
                            Text("Cancel")
                        }
                    },
                    title = {
                        Text("Update Product")
                    },
                    text = {
                        Column() {
                            Text("Product Name:",
                                modifier = Modifier.padding(15.dp),
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 15.sp
                                )
                            )
                            OutlinedTextField(
                                value = pName,
                                onValueChange = { data ->
                                    pName = data
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
                                value = pQuantity,
                                onValueChange = {
                                    pQuantity = it
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
                                value = pRate,
                                onValueChange = { data ->
                                    pRate = data
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
                        }
                    }
                )
            }
        }

        if(loading.value){
            item{
                CircularProgressIndicator()
            }
        }else{
            items(allproducts.value!!.size){
                    index->
                var data = allproducts.value!![index]

                Card(
                    modifier = Modifier.fillMaxWidth().padding(15.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column() {
                            Text(data.productName)
                            Text(data.productQuantity)
                            Text(data.productRate)
                        }
                        Row() {
                            IconButton(onClick = {
                                showDialog = true
                                productViewModel.getProductById(data.productId)
                            }) {
                                Icon(Icons.Default.Edit,
                                    contentDescription = null)
                            }
                            IconButton(onClick = {
                                productViewModel.deleteProduct(data.productId){
                                        success,message->
                                    if(success){
                                        Toast.makeText(context,
                                            message,
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }else{
                                        Toast.makeText(context,
                                            message,
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }
                            }) {
                                Icon(Icons.Default.Delete,contentDescription = null)
                            }
                        }
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
