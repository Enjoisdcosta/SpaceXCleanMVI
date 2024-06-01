package com.example.spacexcleanmvi.ui.compose.nav.login

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color



fun loginFunction(
    email: String,
    password: String,
    auth: FirebaseAuth,
    context: Context,
    navController: NavHostController
) {
   if (!!email.isNotBlank() && !!password.isNotBlank()) {
       FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
           .addOnCompleteListener { task ->
               val user = auth.currentUser
               if (task.isSuccessful && user != null) {
                   navController.navigate("blank")


               } else {
                   Toast.makeText(
                       context,
                       task.exception?.message ?: "Login failed",
                       Toast.LENGTH_SHORT
                   ).show()
               }
           }
   }

}
// login theme




