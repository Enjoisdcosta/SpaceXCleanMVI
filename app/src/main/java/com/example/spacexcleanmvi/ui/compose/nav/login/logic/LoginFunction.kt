package com.example.spacexcleanmvi.ui.compose.nav.login.logic

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth


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




