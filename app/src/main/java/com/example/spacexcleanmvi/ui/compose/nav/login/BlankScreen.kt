package com.example.spacexcleanmvi.ui.compose.nav.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacexcleanmvi.R

@Composable
fun blankScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            stringResource(R.string.LogIn),
            style = MaterialTheme.typography.labelMedium.copy(fontSize = 30.sp),
            modifier = Modifier.padding(bottom = 50.dp)
        )

        Text(
            stringResource(R.string.SignIn),
            style = MaterialTheme.typography.labelMedium.copy(fontSize = 30.sp),
        )
    }

}