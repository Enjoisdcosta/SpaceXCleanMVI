package com.example.spacexcleanmvi

import SignUpScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.CleanArchitectureTheme
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.Login
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.blankScreen
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.blankScreen1
import com.example.spacexcleanmvi.ui.theme.SpaceXCleanMVITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //https://api.spacexdata.com/v3/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanArchitectureTheme {
                val navController = rememberNavController()
                Nav(navController)



                }
            }
        }
    }


@Composable
fun Nav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomBarState = remember { mutableStateOf(true) }
    val navHostController = navController as NavHostController






    NavHost(
        navController = navController,
        startDestination = "login") {

        composable("login") { Login(navController) }
        composable("blank") { blankScreen() }
        composable("blank1") { blankScreen1() }
        composable("signup") { SignUpScreen(navController) }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SpaceXCleanMVITheme {

    }
}