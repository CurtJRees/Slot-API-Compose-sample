package com.curtjrees.slotapisexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.viewModel

@Composable
fun FixtureListScreen(
    itemLayout: @Composable (FixtureItem) -> Unit = { DefaultFixtureItemLayout(it) }
) {
    val viewModel = viewModel<FixtureListViewModel>()
    val viewState = viewModel.viewState.collectAsState()

    val fixtureItems = viewState.value.fixtures

    Column(Modifier.fillMaxWidth().background(Color.White)) {
        TopAppBar {
            Text("Fixture List Screen", modifier = Modifier.align(Alignment.CenterVertically).padding(start = 16.dp), fontSize = 18.sp)
        }

        LazyColumn {
            items(fixtureItems) { fixtureItem ->
                itemLayout.invoke(fixtureItem)
            }
        }
    }
}

@Composable
fun DefaultFixtureItemLayout(fixtureItem: FixtureItem) {
    Text(fixtureItem.toString(), modifier = Modifier.padding(bottom = 24.dp))
}