package com.example.spacexcleanmvi.ui.compose.nav.login.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CheckboxDefaults.colors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.spacexcleanmvi.R
import com.example.spacexcleanmvi.ui.compose.nav.login.logic.loginFunction
import com.google.android.material.internal.ClippableRoundedCornerLayout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import java.time.format.TextStyle


@Composable
fun Login(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    val auth: FirebaseAuth = remember { FirebaseAuth.getInstance() }
    var isLoading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val backgroundImage: Painter = painterResource(id = R.drawable.spacex)
    val lemonMilk = FontFamily(Font(R.font.lemon_milk_bold))
    var isUserLoggedIn by remember { mutableStateOf(auth.currentUser != null) }

    Image(
        painter = backgroundImage,
        contentDescription = stringResource(R.string.app_name),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Login",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = androidx.compose.ui.text.TextStyle(fontFamily = lemonMilk)


            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Username", color = Color.White) },
                modifier = Modifier.fillMaxWidth(),

                isError = email.isEmpty() && email.isNotBlank(),


            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password", color = Color.White) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                isError = password.isEmpty() && password.isNotBlank(),
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(
                onClick = {
                    scope.launch {
                        loginFunction(email, password, auth, context, navController,onLoginSuccess = { isUserLoggedIn = true })
                    }
                },
                modifier = Modifier
                    .width(360.dp)
                    .height(48.dp)
                    .padding(vertical = 1.5.dp),
                border = BorderStroke(1.dp, Color.White),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.DarkGray
                )
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 20.sp)
                )

            }
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(
                onClick = { navController.navigate("signup") },
                modifier = Modifier
                    .width(360.dp)
                    .height(48.dp)
                    .padding(vertical = 1.5.dp),
                border = BorderStroke(1.dp, Color.White),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.DarkGray
                )
            ) {
                Text(
                    stringResource(R.string.SignUP),
                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 20.sp),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedButton(
                onClick = { navController.navigate("blank") },
                modifier = Modifier
                    .width(360.dp)
                    .height(48.dp)
                    .padding(vertical = 1.5.dp),
                border = BorderStroke(1.dp, Color.White),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.DarkGray
                )
            ) {
                Text(
                    text = "Without Login",
                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 20.sp),
                )
            }
        }
    }

}

@Preview
@Composable
fun LoginPreview() {
    Login(navController = rememberNavController())
}


