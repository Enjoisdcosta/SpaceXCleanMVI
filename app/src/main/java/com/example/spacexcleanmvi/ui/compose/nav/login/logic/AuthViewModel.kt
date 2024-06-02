package com.example.spacexcleanmvi.ui.compose.nav.login.logic

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _isUserLoggedIn = MutableStateFlow<Boolean?>(null)
    val isUserLoggedIn: StateFlow<Boolean?> = _isUserLoggedIn

    init {
        viewModelScope.launch {
            _isUserLoggedIn.value = auth.currentUser != null
        }
    }
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
                        _isUserLoggedIn.value = true


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
}
