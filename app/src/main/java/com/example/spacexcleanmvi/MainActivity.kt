package com.example.spacexcleanmvi

import SignUpScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.common.nav.NavRoutes.Companion.ROUTE_BLANK
import com.example.common.nav.NavRoutes.Companion.ROUTE_BLANK1
import com.example.common.nav.NavRoutes.Companion.ROUTE_BLANK2
import com.example.common.nav.NavRoutes.Companion.ROUTE_LOGIN
import com.example.common.nav.NavRoutes.Companion.ROUTE_SIGN_UP
import com.example.spacexcleanmvi.ui.compose.nav.bottombar.BottomAppBar
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.CapsulesScreen
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.BlankScreen1
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.BlankScreen2
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.CleanArchitectureTheme
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.Login
import com.example.spacexcleanmvi.ui.viewmodel.capsules.CapsuleListViewModel

import com.google.firebase.auth.FirebaseAuth
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
                Nav(hiltViewModel(),navController)


            }
        }
    }
}


@Composable
fun Nav(viewModel: CapsuleListViewModel,
        navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomBarState = remember { mutableStateOf(true) }
    val navHostController = navController as NavHostController
    val auth = remember { FirebaseAuth.getInstance() }
    var isUserLoggedIn by remember { mutableStateOf(auth.currentUser != null) }

//    val state by viewModel.state.collectAsState()

    Scaffold(

        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            if (currentRoute in listOf(
                    ROUTE_BLANK,
                    ROUTE_BLANK1,
                    ROUTE_BLANK2,
                )
            ) {
                BottomAppBar(navController)

//                if (bottomBarState.value) {
//                    BottomAppBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = if (isUserLoggedIn) ROUTE_BLANK else ROUTE_LOGIN,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(ROUTE_LOGIN) { Login(navController) }
            composable(ROUTE_BLANK) { CapsulesScreen(hiltViewModel(), navController) }
            composable(ROUTE_BLANK1) { BlankScreen1() }
            composable(ROUTE_BLANK2) { BlankScreen2() }
            composable(ROUTE_SIGN_UP) { SignUpScreen(navController) }
        }

    }
}

//@Composable
//fun MyApp() {
//    val auth = FirebaseAuth.getInstance()
//    var isUserLoggedIn by remember { mutableStateOf(auth.currentUser != null) }
//
//
//    if (isUserLoggedIn) {
//        Nav(rememberNavController())
//    } else {
//        Nav(rememberNavController())
//    }
//}


@Composable
fun App(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomBarState = remember { mutableStateOf(true) }

}






