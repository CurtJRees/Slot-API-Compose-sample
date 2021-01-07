package com.curtjrees.slotapisexample

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class FixtureListViewModel : ViewModel() {

    val viewState = MutableStateFlow(ViewState())

    init {
        viewState.value = ViewState(
            fixtures = listOf(
                upcomingFixture,
                liveFixture,
                resultFixture
            )
        )
    }


    data class ViewState(
        val fixtures: List<FixtureItem> = emptyList()
    )
}