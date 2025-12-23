//package com.example.FirstComposeApp.view
//
//import android.app.Activity
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Checkbox
//import androidx.compose.material3.CheckboxDefaults
//import androidx.compose.material3.HorizontalDivider
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.SnackbarHost
//import androidx.compose.material3.SnackbarHostState
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.SpanStyle
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.buildAnnotatedString
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.withStyle
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.window.DialogProperties
//import com.example.FirstComposeApp.view.DashboardActivity
//import com.example.FirstComposeApp.R
//import com.example.FirstComposeApp.repository.UserRepoImpl
//import com.example.FirstComposeApp.ui.theme.PurpleGrey80
//import com.example.FirstComposeApp.view.ui.theme.FirstComposeAppTheme
//import com.example.FirstComposeApp.viewmodel.UserViewModel
//
//class ForgetPassword : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//
//        }
//    }
//}
//@Composable
//fun ForgetPasswordBody() {
//
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    val userViewModel = remember { UserViewModel(UserRepoImpl()) }
//
//    val context = LocalContext.current
//
//    val activity = context as Activity
//
//    val snackbarHostState = remember { SnackbarHostState() }
//
//    val coroutineScope = rememberCoroutineScope()
//
//    var showDialog by remember { mutableStateOf(false) }
//
//    val sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE)
//
//    val editor = sharedPreferences.edit()
//
//    Scaffold(
//        snackbarHost = {
//            SnackbarHost(hostState = snackbarHostState)
//        }
//    ) { padding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)
//                .background(Color.White)
//        ) {
//            Spacer(modifier = Modifier.height(50.dp))
//            Text(
//                "Sign In",
//                style = TextStyle(
//                    textAlign = TextAlign.Center,
//                    fontSize = 24.sp,
//                    color = Color.Blue,
//                    fontWeight = FontWeight.Bold
//                ),
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Text(
//                "This is lorem ipsum, this is ecommerce here you can buy any produycts you want",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 20.dp),
//                style = TextStyle(
//                    textAlign = TextAlign.Center,
//                    color = Color.Black.copy(0.5f)
//                )
//            )
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 40.dp, horizontal = 20.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//
//                HorizontalDivider(
//                    modifier = Modifier.weight(1f)
//                )
//
//                Text("OR", modifier = Modifier.padding(horizontal = 20.dp))
//                HorizontalDivider(
//                    modifier = Modifier.weight(1f)
//                )
//            }
//
//            OutlinedTextField(
//                value = email,
//                onValueChange = { data ->
//                    email = data
//                },
//                keyboardOptions = KeyboardOptions(
//                    keyboardType = KeyboardType.Email
//                ),
//                placeholder = {
//                    Text("abc@gmail.com")
//                },
//                colors = TextFieldDefaults.colors(
//                    unfocusedContainerColor = PurpleGrey80,
//                    focusedContainerColor = PurpleGrey80,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Transparent
//                ),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 15.dp),
//                shape = RoundedCornerShape(15.dp)
//            )
//
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            OutlinedTextField(
//                value = password,
//                onValueChange = { data ->
//                    password = data
//                },
//                placeholder = {
//                    Text("********")
//                },
//                trailingIcon = {
//                    IconButton(onClick = {
//                        visibility = !visibility
//                    }) {
//                        Icon(
//                            painter = if (visibility)
//                                painterResource(R.drawable.baseline_visibility_24)
//                            else
//                                painterResource(R.drawable.baseline_visibility_off_24),
//
//                            contentDescription = null
//                        )
//                    }
//                },
//                visualTransformation = if (!visibility) PasswordVisualTransformation() else VisualTransformation.None,
//                colors = TextFieldDefaults.colors(
//                    unfocusedContainerColor = PurpleGrey80,
//                    focusedContainerColor = PurpleGrey80,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Transparent
//                ),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 15.dp),
//                shape = RoundedCornerShape(15.dp)
//            )
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Text("Forget Password", modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 15.dp), style = TextStyle(textAlign = TextAlign.Center))
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Checkbox(
//                    checked = terms,
//                    onCheckedChange = {
//                        terms = it
//                    },
//                    colors = CheckboxDefaults.colors(
//                        checkedColor = Color.Blue,
//                        checkmarkColor = Color.White
//                    )
//                )
//                Text("Remember me")
//            }
//
////            Button(onClick = {
////                val intent = Intent(
////                    context, DashboardActivity::class.java
////                )
////                intent.putExtra("email",email)
////                intent.putExtra("password",password)
////                context.startActivity(intent)
////                activity.finish()
////            },
////                shape = RoundedCornerShape(10.dp),
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(horizontal = 15.dp, vertical = 20.dp),
////                colors = ButtonDefaults.buttonColors(
////                    containerColor = Color.Blue
////                )
////            ) {
////                Text("Log In")
////            }
//            Button(onClick = {
//                userViewModel.login(email,password){
//                        success,message->
//                    if (success){
//                        Toast.makeText(context,
//                            message,
//                            Toast.LENGTH_LONG
//                        ).show()
//                        val intent = Intent(
//                            context,
//                            DashboardActivity::class.java
//                        )
//
//                        context.startActivity(intent)
//
//                        activity.finish()
//
//                    }else{
//                        Toast.makeText(context,
//                            message,
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//                }
//
//            },
//                shape = RoundedCornerShape(10.dp),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 15.dp, vertical = 20.dp),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color.Blue
//                )
//            ) {
//                Text("Log Up")
//            }
//
//            Text(buildAnnotatedString {
//                append("Don't have account? ")
//
//                withStyle(SpanStyle(color = Color.Blue)){
//                    append("Sign up")
//                }
//            },
//                modifier = Modifier.clickable{
//                    val intent = Intent(
//                        context,
//                        SignUpActivity::class.java
//                    )
//
//                    context.startActivity(intent)
//
//                    activity.finish()
//                })
//        }
//    }
//}