package com.example.spacexcleanmvi.ui.compose.nav.bottombar

import SignUpScreen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.common.nav.NavRoutes
import com.example.spacexcleanmvi.R
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.Login
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.blankScreen
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.blankScreen1
import com.example.spacexcleanmvi.ui.compose.nav.login.ui.blankScreen2
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun BottomAppBar(navController: NavHostController) {
    var showSignOutDialog by remember { mutableStateOf(false) }

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.DarkGray
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = stringResource(R.string.app_name)
                )
            },
            selected = navController.currentDestination?.route == NavRoutes.ROUTE_BLANK,
            onClick = {
                navController.navigate(NavRoutes.ROUTE_BLANK) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Filled.AccountBox,
                    contentDescription = stringResource(R.string.app_name)
                )
            },
            selected = navController.currentDestination?.route == NavRoutes.ROUTE_BLANK1,
            onClick = {
                navController.navigate(NavRoutes.ROUTE_BLANK1) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = stringResource(R.string.app_name)

                )
            },
            selected = navController.currentDestination?.route == NavRoutes.ROUTE_BLANK2,
            onClick = {
                navController.navigate(NavRoutes.ROUTE_BLANK2) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                  //  Icons.AutoMirrored.Filled.ExitToApp,
                    Icons.Filled.Close,
                    contentDescription = stringResource(R.string.app_name)
                )
            },
            selected = false,
            onClick = { showSignOutDialog = true }
        )
    }

    if (showSignOutDialog) {
        AlertDialog(
            onDismissRequest = { showSignOutDialog = false },
            title = { Text(stringResource(R.string.SignOut)) },
            text = { Text(stringResource(R.string.SignOut)) },
            confirmButton = {
                OutlinedButton(
                    onClick = {
                        showSignOutDialog = false
                        Firebase.auth.signOut()
                        navController.navigate(NavRoutes.Login.route) {
                            popUpTo(NavRoutes.Movies.route) { inclusive = true }
                        }

                    },
                    modifier = Modifier
                        .width(80.dp)
                        .height(48.dp)
                        .padding(vertical = 1.5.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(stringResource(R.string.Yes))
                }
            },
            dismissButton = {
                TextButton(onClick = { showSignOutDialog = false }) {
                    Text(
                        stringResource(R.string.No),
                        color = Color.Black,
                        modifier = Modifier
                            .height(48.dp)
                            .padding(vertical = 1.5.dp),
                    )
                }
            }
        )
    }
}