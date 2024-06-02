package com.example.spacexcleanmvi.ui.compose.nav.signup.logic

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth


fun SignUp(
    name: String,
    email: String,
    password: String,
    auth: FirebaseAuth,
    context: Context,
    navController: NavHostController
) {
    if (!!name.isNotBlank() && !!email.isNotBlank() && !!password.isNotBlank()) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {task->
                if (task.isSuccessful) {
                    navController.navigate("login")
                }
                else {
                    Toast.makeText(
                        context,
                        task.exception?.message ?: "SignUp failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
    }


}
