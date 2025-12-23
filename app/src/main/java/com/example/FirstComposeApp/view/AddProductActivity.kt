package com.example.FirstComposeApp.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import coil3.compose.AsyncImage
import com.example.FirstComposeApp.R
import com.example.FirstComposeApp.model.ProductModel
import com.example.FirstComposeApp.repository.ProductRepoImpl
import com.example.FirstComposeApp.ui.theme.PurpleGrey80
import com.example.FirstComposeApp.utils.ImageUtils
import com.example.FirstComposeApp.view.ui.theme.FirstComposeAppTheme
import com.example.FirstComposeApp.viewmodel.ProductViewModel

class AddProductActivity : ComponentActivity() {
    lateinit var imageUtils: ImageUtils
    var selectedImageUri by mutableStateOf<Uri?>(null)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        imageUtils = ImageUtils(this, this)
        imageUtils.registerLaunchers { uri ->
            selectedImageUri = uri
        }
        setContent {
            AddProductScreen(
                selectedImageUri = selectedImageUri,
                onPickImage = { imageUtils.launchImagePicker() }
            )
        }
    }
}

@Composable
fun AddProductScreen(
    selectedImageUri: Uri?,
    onPickImage: () -> Unit
) {

    var productName by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
    var productRate by remember { mutableStateOf("") }

    val context = LocalContext.current

    val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {

        item {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        onPickImage()
                    }
                    .padding(10.dp)
            ) {
                if (selectedImageUri != null) {
                    AsyncImage(
                        model = selectedImageUri,
                        contentDescription = "Selected Image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        painterResource(R.drawable.placeholder),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Text(
                "Product Name:",
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

            Text(
                "Product Quantity:",
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
            Text(
                "Product Rate:",
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

            Button(
                onClick = {

                    if (selectedImageUri != null) {
                        productViewModel.uploadImage(context, selectedImageUri) { imageUrl ->
                            if (imageUrl != null) {

                                val model = ProductModel(
                                    productName = productName,
                                    productQuantity = productQuantity,
                                    productRate = productRate
                                )
                                productViewModel.addProduct(model) { success, message ->
                                    if (success) {
                                        Toast.makeText(
                                            context,
                                            message,
                                            Toast.LENGTH_LONG
                                        ).show()
                                        val intent = Intent(
                                            context,
                                            DashboardActivity::class.java
                                        )
                                        context.startActivity(intent)
                                    } else {
                                        Toast.makeText(
                                            context,
                                            message,
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }
                            } else {
                                Log.e("Upload Error", "Failed to upload image to Cloudinary")
                            }
                        }
                    } else {
                        Toast.makeText(
                            context,
                            "Please select an image first",
                            Toast.LENGTH_SHORT
                        ).show()
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
}

@Preview
@Composable
fun ProductPreview() {
    AddProductScreen(
        selectedImageUri = null, // or pass a mock Uri if needed
        onPickImage = {} // no-op
    )
}