//package com.example.spacexcleanmvi.ui.compose.nav.screen
//
//import android.util.Log
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.Font
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.common.nav.state.CommonScreen
//import com.example.spacexcleanmvi.R
//import com.example.spacexcleanmvi.ui.model.Capsule
//import com.example.spacexcleanmvi.ui.model.CapsuleListModel
//import com.example.spacexcleanmvi.ui.model.History
//import com.example.spacexcleanmvi.ui.model.HistoryListModel
//import com.example.spacexcleanmvi.ui.uiaction.capsule.CapsuleListAction
//import com.example.spacexcleanmvi.ui.uiaction.capsule.CapsuleListSingleEvent
//import com.example.spacexcleanmvi.ui.uiaction.history.HistoryListAction
//import com.example.spacexcleanmvi.ui.uiaction.history.HistoryListSingleEvent
//import com.example.spacexcleanmvi.ui.viewmodel.capsules.CapsuleListViewModel
//import com.example.spacexcleanmvi.ui.viewmodel.history.HistoryListViewModel
//import kotlinx.coroutines.flow.collectLatest
//
//
//@Composable
//fun HistoryScreen(
//    viewModel: HistoryListViewModel,
//    navController: NavController
//) {
//    LaunchedEffect(Unit) {
//        viewModel.submitAction(HistoryListAction.Load)
//    }
//
//    viewModel.uiStateFlow.collectAsState().value.let { state ->
//        CommonScreen(state = state) {
//            Column {
//                HistoryList(it) { item ->
//                    viewModel.submitAction(
//                        HistoryListAction.OnHistoryItemClick(
//                            item.title,
//                            item.id
//                        )
//                    )
//
//                }
//
//            }
//        }
//
//
//    }
//    LaunchedEffect(Unit) {
//        viewModel.singleEventFlow.collectLatest {
//            when (it) {
//                is HistoryListSingleEvent.OpenDetailsScreen -> {
//                    Log.i("ROUTE", it.navRoute)
//                    navController.navigate(it.navRoute)
//                }
//            }
//        }
//    }
//
//}
//
//@Composable
//fun HistoryList(
//    model: HistoryListModel,
//    onItemClick: (History) -> Unit
//) {
//    LazyColumn {
//        items(model.items) { history ->
//            HistoryItem(history = history, onItemClick = onItemClick)
//        }
//    }
//}
//@Composable
//fun HistoryItem(history: History, onItemClick: (History) -> Unit) {
//    val lemonMilk = FontFamily(Font(R.font.lemon_milk_bold))
//
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = Color.Black)
//            .clickable { onItemClick(history) },
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Text(text = "Title: ${history.title}",
//                fontSize = 28.sp,
//                color = Color.Black,
//                fontWeight = FontWeight.Bold,
//                style = TextStyle(fontFamily = lemonMilk)
//            )
//            Text(
//                text = "Id: ${history.id}",
//
//                )
//            Text(text = "Details: ${history.details}")
//            Text(text = "Event Date Utc: ${history.eventDateUtc}")
//            Text(text = "Flight Number: ${history.flightNumber}")
//
//        }
//    }
//}