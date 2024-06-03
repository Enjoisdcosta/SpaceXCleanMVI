import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.spacexcleanmvi.R
import com.example.spacexcleanmvi.ui.compose.nav.signup.logic.SignUp
import com.google.firebase.auth.FirebaseAuth


@Composable
fun SignUpScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    val auth: FirebaseAuth = remember { FirebaseAuth.getInstance() }


    val backgroundImage: Painter = painterResource(id = R.drawable.spacex)
    val lemonMilk = FontFamily(Font(R.font.lemon_milk_bold))

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
                text = "Sign Up", fontSize = 32.sp, color = Color.White,
                fontWeight = FontWeight.Bold,
                style = androidx.compose.ui.text.TextStyle(fontFamily = lemonMilk)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "Name", color = Color.White) },
                textStyle = androidx.compose.material3.LocalTextStyle.current.copy(color = Color.White),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email", color = Color.White) },
                textStyle = androidx.compose.material3.LocalTextStyle.current.copy(color = Color.White),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password", color = Color.White) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                textStyle = androidx.compose.material3.LocalTextStyle.current.copy(color = Color.White),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.OutlinedButton(
                onClick = {
                    SignUp(name, email, password, auth, context, navController)
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
                    text = "Sign Up",
                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 20.sp),
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.OutlinedButton(
                onClick = {
                    navController.navigate("login")
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
                    text = "Already Have Login",
                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 20.sp),
                    color = Color.White
                )
            }
        }
    }
}