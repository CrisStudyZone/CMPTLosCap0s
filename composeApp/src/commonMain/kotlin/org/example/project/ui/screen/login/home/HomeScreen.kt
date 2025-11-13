package org.example.project.ui.screen.login.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.data.itemList
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel  = koinViewModel()){

    viewModel.fetchPopularMovies()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = WindowInsets.statusBars.asPaddingValues()
    ){
        items(itemList, key = { it.id }){
            item ->
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = item.title)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.description)
            }
        }
    }
}