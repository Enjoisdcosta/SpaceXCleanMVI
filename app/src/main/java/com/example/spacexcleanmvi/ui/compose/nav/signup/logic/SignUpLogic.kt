package com.example.spacexcleanmvi.ui.compose.nav.signup.logic

import android.content.Context
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
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {task->
                if (task.isSuccessful) {
                    navController.navigate("login")
                }

            }
    }


}
