package com.example.spacexcleanmvi.ui.compose.nav.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacexcleanmvi.R
import com.example.spacexcleanmvi.ui.viewmodel.MainViewModel
import kotlinx.coroutines.flow.forEach

@Composable
fun BlankScreen(){
//    val state by viewModel.state.collectAsState()
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
            stringResource(R.string.Capsules),
            style = MaterialTheme.typography.labelMedium.copy(fontSize = 30.sp),
        )
    }

}

@Composable
fun BlankScreen1(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            stringResource(R.string.History),
            style = MaterialTheme.typography.labelMedium.copy(fontSize = 30.sp),
            modifier = Modifier.padding(bottom = 50.dp)
        )

    }

}
@Composable
fun BlankScreen2(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            stringResource(R.string.Launches),
            style = MaterialTheme.typography.labelMedium.copy(fontSize = 30.sp),
            modifier = Modifier.padding(bottom = 50.dp)
        )

    }

}
//@Composable
//fun CapsuleScreen(viewModel: MainViewModel){
//    val state by viewModel.state.collectAsState()
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Green)
//    )
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        if (state.isEmpty()) {
//            CircularProgressIndicator()
//        } else {
//            state.forEach { data ->
//                Text(text = data.)
//            }
//        }
//    }
//}
//}