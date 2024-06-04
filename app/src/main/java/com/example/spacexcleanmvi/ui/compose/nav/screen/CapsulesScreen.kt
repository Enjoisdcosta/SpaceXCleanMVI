package com.example.spacexcleanmvi.ui.compose.nav.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.common.nav.NavRoutes
import com.example.common.nav.NavRoutes.Companion.ROUTE_BLANK
import com.example.common.nav.state.CommonScreen
import com.example.spacexcleanmvi.R
import com.example.spacexcleanmvi.ui.model.Capsule
import com.example.spacexcleanmvi.ui.model.CapsuleListModel
import com.example.spacexcleanmvi.ui.uiaction.capsule.CapsuleListAction
import com.example.spacexcleanmvi.ui.uiaction.capsule.CapsuleListSingleEvent
import com.example.spacexcleanmvi.ui.viewmodel.capsules.CapsuleListViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CapsulesScreen(
    viewModel: CapsuleListViewModel,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        viewModel.submitAction(CapsuleListAction.Load)
    }

    viewModel.uiStateFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column {
                CapsuleList(it) { item ->
                    viewModel.submitAction(
                        CapsuleListAction.OnCapsuleItemClick(
                            item.capsuleId
                        )
                    )

                }

            }
        }


    }
    LaunchedEffect(Unit) {
        viewModel.singleEventFlow.collectLatest {
            when (it) {
                is CapsuleListSingleEvent.OpenDetailsScreen -> {
                    Log.i("ROUTE", it.navRoute)
                    navController.navigate(it.navRoute)
                }
            }
        }
    }

}


@Composable
fun CapsuleList(
    model: CapsuleListModel,
    onItemClick: (Capsule) -> Unit
) {
    LazyColumn {
        items(model.items) { capsule ->
            CapsuleItem(capsule = capsule, onItemClick = onItemClick)
        }
    }
}


@Composable
fun CapsuleItem(capsule: Capsule, onItemClick: (Capsule) -> Unit) {
    val lemonMilk = FontFamily(Font(R.font.lemon_milk_bold))




    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .clickable { onItemClick(capsule) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Status: ${capsule.status}",
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = androidx.compose.ui.text.TextStyle(fontFamily = lemonMilk))
            Text(
                text = "Id: ${capsule.capsuleId}",

            )
            Text(text = "Details: ${capsule.details}")
            Text(text = "Original Launch: ${capsule.originalLaunch}")
            Text(text = "Landing: ${capsule.landings}")

        }
    }
}

@Composable
fun BlankScreen1() {
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
fun BlankScreen2() {
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
@Composable
fun CapsuleDetailsScreen(capsuleInput: NavRoutes.CapsuleInput, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = { navController.navigate(ROUTE_BLANK) }) {
            IconButton(

                onClick = { navController.navigate(ROUTE_BLANK) },
                modifier = Modifier
                    .padding(8.dp)
                    .size(10.dp),


                ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",

                    )
            }
        }

        Text(
            text = "Details: ${capsuleInput.capsuleId}",
            style = androidx.compose.material.MaterialTheme.typography.body1
        )

    }
}