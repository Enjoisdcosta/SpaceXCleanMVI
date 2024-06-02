package com.example.spacexcleanmvi

import SignUpScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.common.nav.NavRoutes
import com.example.common.nav.NavRoutes.Companion.ROUTE_LOGIN
import com.example.common.nav.NavRoutes.Companion.ROUTE_SIGN_UP
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
        startDestination = ROUTE_LOGIN) {

        composable(ROUTE_LOGIN) { Login(navController) }
        composable("blank") { blankScreen() }
        composable("blank1") { blankScreen1() }
        composable(ROUTE_SIGN_UP) { SignUpScreen(navController) }
    }

}
@Composable
fun App(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomBarState = remember { mutableStateOf(true) }

}


@Composable
fun BottomAppBar(navController: NavHostController) {
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SpaceXCleanMVITheme {

    }
}