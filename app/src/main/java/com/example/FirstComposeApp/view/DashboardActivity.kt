package com.example.FirstComposeApp.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.FirstComposeApp.NotificationScreen
import com.example.FirstComposeApp.R
import com.example.FirstComposeApp.SearchScreen

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dashboard()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(){

    val context = LocalContext.current
    val activity = context as Activity

    val email = activity.intent?.getStringExtra("email")
    val password = activity.intent?.getStringExtra("password")

    data class NavItem(val label: String, val icon: Int)

    var selectedIndex by remember { mutableStateOf(0) }

    var listNav = listOf(
        NavItem(label = "Home",
            icon = R.drawable.baseline_home_24),
        NavItem(label = "Search",
            icon = R.drawable.baseline_search_24),
        NavItem(label = "Workplace",
            icon = R.drawable.baseline_workspace_premium_24),
        NavItem(label = "More",
            icon = R.drawable.baseline_view_module_24)
    )

    Scaffold(
        floatingActionButton ={
            FloatingActionButton(onClick = {
                val intent = Intent(context,
                    AddProductActivity::class.java)
                context.startActivity(intent)
            }) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = null
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {Text("Dashboard")},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            activity.finish()
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_arrow_back_ios_new_24),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_notifications_24),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                listNav.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(item.label)
                        },
                        onClick = {
                            selectedIndex = index
                        },
                        selected = selectedIndex == index
                    )
                }
            }
        }
    ) {padding ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
        ) {
            when(selectedIndex){
                0-> HomeScreen1()
                1-> SearchScreen()
                2-> NotificationScreen()
                3-> MoreScreen()
                else -> HomeScreen1()
            }
    }
    }
}

@Preview
@Composable
fun DashboardPreview(){
    Dashboard()
}